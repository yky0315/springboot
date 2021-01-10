package com.oracle.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.oracle.mapper.ProductMapper;
import com.oracle.pojo.Product;
import com.oracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> selectProductList(Integer size) {
        String productListKey="product_cache";
        String jsonstr = redisTemplate.boundValueOps(productListKey).get();
        List<Product> list=null;
        if(jsonstr!=null){
            return JSONObject.parseArray(jsonstr, Product.class);
        }
        list = productMapper.selectProduct(size);
        String liststr = JSONObject.toJSONString(list);
        redisTemplate.boundValueOps(productListKey).set(liststr);
        return list;
    }
    @Override
    public Product selectProductById(Integer id) {
        String productKey="product:"+id;
        String jsonstr = redisTemplate.boundValueOps(productKey).get();
        if(jsonstr!=null){
            Product product = JSONObject.parseObject(jsonstr, Product.class);
            return product;
        }
        Product product = productMapper.selectByPrimaryKey(id);
        jsonstr = JSONObject.toJSONString(product);
        redisTemplate.boundValueOps(productKey).set(jsonstr);
        return product;
    }
}
