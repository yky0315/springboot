package com.oracle.controller;

import com.oracle.pojo.News;
import com.oracle.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @RequestMapping("/getNews")
    public News SelectByNewsId(Integer id){
        return newsService.SelectByNewsId(id);
    }

    @RequestMapping("/update")
    public News updateByNewsId(Integer id){
       return newsService.updateByNewsId(id);
    }
    @RequestMapping("/delete")
    public boolean deleteByNewsId(Integer id){
        return newsService.deleteByNewsId(id);
    }
}
