package com.oracle.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.oracle.mapper.ProductMapper;
import com.oracle.pojo.Cart;
import com.oracle.pojo.Product;
import com.oracle.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
* 用户登陆情况下通过hash存储购物车数据到缓存
* */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Value("${productCacheKey}")
    private String productCacheKey;

    @Override
    public int addCart(Integer proId, String loginName) {
        Product product = null;
        String productKey = productCacheKey + proId;
        String productJsonStr = redisTemplate.boundValueOps(productKey).get();
        if (productJsonStr != null) {
            product = JSONObject.parseObject(productJsonStr, Product.class);
            //判断用户是否有购物车
            boolean flag = doaddCart(product, loginName);
            if (flag) {
                return 200;
            }
        } else {
            product = productMapper.selectByPrimaryKey(proId);
            productJsonStr = JSONObject.toJSONString(product);
            redisTemplate.boundValueOps(productKey).set(productJsonStr);
            boolean flag = doaddCart(product, loginName);
            if (flag) {
                return 200;
            }
        }
        return 0;
    }


    public boolean doaddCart(Product product, String loginname){
      String redisCartListKey=productCacheKey+"carts";
        String  redisCartJsonStr = (String)redisTemplate.boundHashOps(redisCartListKey).get(loginname);
        if(redisCartJsonStr!=null){
            List<Cart> carts = JSONObject.parseArray(redisCartJsonStr, Cart.class);
            for (int i = 0; i < carts.size(); i++) {
                if(product.getId().equals(carts.get(i).getProId())){
                    carts.get(i).setPronum(carts.get(i).getPronum()+1);
                    //更新缓存
                    redisCartJsonStr = JSONObject.toJSONString(carts);
                    redisTemplate.boundHashOps(redisCartListKey).put(loginname, redisCartJsonStr);
                    return true;
                }
            }
            Cart cart = new Cart();
            cart.setPronum(1);
            cart.setProFullName(product.getProfullname());
            cart.setProId(product.getId());
            cart.setProImg(product.getProimg());
            cart.setProName(product.getProname());
            cart.setProPrice(product.getProprice());
            carts.add(cart);
            redisCartJsonStr=JSONObject.toJSONString(carts);
            redisTemplate.boundHashOps(redisCartListKey).put(loginname, redisCartJsonStr);
            return true;
        }else{
            ArrayList list = new ArrayList();
            Cart cart = new Cart();
            cart.setPronum(1);
            cart.setProFullName(product.getProfullname());
            cart.setProId(product.getId());
            cart.setProImg(product.getProimg());
            cart.setProName(product.getProname());
            cart.setProPrice(product.getProprice());
            list.add(cart);
            redisCartJsonStr=JSONObject.toJSONString(list);
            redisTemplate.boundHashOps(redisCartListKey).put(loginname, redisCartJsonStr);
            return true;
        }
    }


    /*
* 登录状态下购物车合并
* */
    @Override
    public List<Cart> mergeList(String loginname, List<Cart> cookieCartList) {
        String redisCartListKey=productCacheKey+"carts";
        String  redisCartJsonStr= (String) redisTemplate.boundHashOps(redisCartListKey).get(loginname);
        if(redisCartJsonStr!=null){
            //redis中购物车不空   合并
            List<Cart> redisCarts = JSONObject.parseArray(redisCartJsonStr, Cart.class);
            for (int i = 0; i < redisCarts.size(); i++) {
                for (int j = 0; j < cookieCartList.size(); j++) {
                    if(redisCarts.get(i).getProId().equals(cookieCartList.get(j).getProId())){
                        redisCarts.get(i).setPronum(redisCarts.get(i).getPronum()+cookieCartList.get(j).getPronum());
                        //在cookieCartList中，将redis购物车与cookie中相同的商品移除
                        cookieCartList.remove(cookieCartList.get(j));
                        break;
                    }
                }
            }
            //不相同的商品放入到redis中
            redisCarts.addAll(cookieCartList);
            return redisCarts;
        }else{
            //将cookie中购物车信息转为redis存储
            String cookieCartJsonStr = JSONObject.toJSONString(cookieCartList);
            redisTemplate.boundHashOps(redisCartListKey).put(loginname, cookieCartJsonStr);
            List<Cart> redisCarts = JSONObject.parseArray(cookieCartJsonStr, Cart.class);
            return redisCarts;
        }
    }
}
