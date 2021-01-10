package com.oracle.application.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oracle.application.entity.News;
import com.oracle.application.mapper.NewsMapper;
import com.oracle.application.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yky
 * @since 2020-12-11
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private INewsService iNewsService;
    @Autowired
    private NewsMapper newsMapper;
   @RequestMapping("/page")
    public void page(){
       Page<News> newsPage = new Page<>(1, 2);
       IPage<News> userIPage=newsMapper.selectPage(newsPage, new QueryWrapper<News>());
       System.out.println(userIPage.getTotal());
       System.out.println(userIPage.getPages());
   }
}
