package com.oracle.service;

import com.oracle.pojo.News;

public interface NewsService {

    public News SelectByNewsId(Integer id);
    public News updateByNewsId(Integer id);

    public boolean deleteByNewsId(Integer id);
}
