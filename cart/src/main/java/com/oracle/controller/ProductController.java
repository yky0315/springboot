package com.oracle.controller;

import com.oracle.pojo.Product;
import com.oracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/getPro")
    public String index(Integer id, Model model){
        Product product = productService.selectProductById(id);
        model.addAttribute("product", product);
        return "product/product";
    }
}
