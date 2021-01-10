package com.oracle.controller;
import com.alibaba.fastjson.JSONObject;
import com.oracle.mapper.ProductMapper;
import com.oracle.pojo.Cart;
import com.oracle.pojo.Product;
import com.oracle.pojo.Users;
import com.oracle.service.CartService;
import com.oracle.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CartService cartService;
    @Value("${cart_cookie_name}")
    private String cookieName;
    @ResponseBody
    @RequestMapping("/add")
    public Map add(Integer id,HttpServletRequest request, HttpServletResponse response, HttpSession session){
        Product product = productMapper.selectByPrimaryKey(id);
        HashMap map = new HashMap();
        if(session.getAttribute("user")==null){
            //用户匿名状态（未登录）
            String cookies = CookieUtil.getCookieValue(request, cookieName, true);
            if(cookies!=null) {
                //用户购物车不为空
                List<Cart> list = JSONObject.parseArray(cookies, Cart.class);
                for (int i = 0; i < list.size(); i++) {
                    if (product.getId().equals(list.get(i).getProId())) {
                        list.get(i).setPronum(list.get(i).getPronum() + 1);
                        cookies = JSONObject.toJSONString(list);
                        CookieUtil.setCookie(request, response, cookieName, cookies, 3600 * 12 * 7, true);
                        map.put("code", 200);
                        return map;
                    }
                }
                Cart cart = new Cart();
                cart.setProFullName(product.getProfullname());
                cart.setProId(product.getId());
                cart.setProImg(product.getProimg());
                cart.setPronum(1);
                cart.setProName(product.getProname());
                cart.setProPrice(product.getProprice());
                list.add(cart);
                cookies=JSONObject.toJSONString(list);
                CookieUtil.setCookie(request, response, cookieName, cookies, 3600 * 12 * 7, true);
                map.put("code", 200);
                return map;
            }else{
                //匿名状态购物车为空
                Cart cart = new Cart();
                cart.setProFullName(product.getProfullname());
                cart.setPronum(1);
                cart.setProId(product.getId());
                cart.setProImg(product.getProimg());
                cart.setProName(product.getProname());
                cart.setProPrice(product.getProprice());
                ArrayList list = new ArrayList();
                list.add(cart);
                cookies=JSONObject.toJSONString(list);
                CookieUtil.setCookie(request, response, cookieName, cookies, 3600 * 12 * 7, true);
                map.put("code", 200);
                return map;
            }
        }else{
            //用户登录状态
            Users user = (Users) session.getAttribute("user");
            cartService.addCart(id, user.getLoginname());
            map.put("code", 200);
            return map;
        }
    }
    @RequestMapping("/list")
    public String cart(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model){
        Users user =(Users) session.getAttribute("user");
        String cookieListStr = CookieUtil.getCookieValue(request, cookieName, true);
        List<Cart> cartList =null;
        if(user!=null){
            if(cookieListStr!=null){
                List<Cart> carts = JSONObject.parseArray(cookieListStr, Cart.class);
                cartList = cartService.mergeList(user.getLoginname(), carts);
            }
        }else{
            cartList=JSONObject.parseArray(cookieListStr, Cart.class);
        }
        model.addAttribute("cartList", cartList);
        return "/cart/list";
    }
}
