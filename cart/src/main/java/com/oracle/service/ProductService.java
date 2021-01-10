package com.oracle.service;

import com.oracle.pojo.Product;

import java.util.List;

public interface ProductService {


    List<Product> selectProductList(Integer size);

    Product selectProductById(Integer id);
}
