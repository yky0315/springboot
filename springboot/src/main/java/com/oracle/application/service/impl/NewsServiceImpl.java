package com.oracle.application.service.impl;

import com.oracle.application.entity.News;
import com.oracle.application.mapper.NewsMapper;
import com.oracle.application.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2020-12-11
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

}
