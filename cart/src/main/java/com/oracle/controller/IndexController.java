package com.oracle.controller;

import com.oracle.pojo.Product;
import com.oracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/index")
public class IndexController {
@Autowired
private ProductService productService;
    @RequestMapping("/in")
    public String index(Model model){
        List<Product> list = productService.selectProductList(10);
        model.addAttribute("initProList", list);
        return "index";
    }
}
