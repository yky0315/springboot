package com.oracle.service;

import com.oracle.pojo.Cart;

import java.util.List;

public interface CartService {

public int addCart(Integer proId,String loginName);

public List<Cart>  mergeList(String loginname,List<Cart> cookieCartList);
}
