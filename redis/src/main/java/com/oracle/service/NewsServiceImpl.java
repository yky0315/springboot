package com.oracle.service;
import com.alibaba.fastjson.JSONObject;
import com.oracle.mapper.NewsMapper;
import com.oracle.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
* 缓存穿透  缓存雪崩
* 1.缓存穿透： 大并发量  一个缓存失效 （无缓存  大量查询数据库）
* 2.缓存雪崩   当缓存很多  出现失效   造成同一时间大量访问数据库
*
* @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中
* */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value("${CACHE_PREFIX}")
    private String Cache;
    @Override
    public News SelectByNewsId(Integer id) {
        String key=Cache+"news:"+id;
        String jsonstr=redisTemplate.boundValueOps(key).get();
        News news=null;
        if(jsonstr!=null){
            System.out.println("从缓存redis拿数据");
            news= JSONObject.parseObject(jsonstr, News.class);
            return news;
        }
        System.out.println("从数据库MySQL中取数据");
        news=newsMapper.selectByPrimaryKey(id);
        jsonstr= JSONObject.toJSONString(news);
        redisTemplate.boundValueOps(key).set(jsonstr);
        return news;
    }
/*
* 如果后台管理员对新闻数据发生变动后 需要将缓存数据更新
* 1.更新数据库数据
* 2.更新缓存数据   set key value 覆盖
*
*更新数据时  判断数据是否为用户关注点       如果是则必须更新缓存
* */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,readOnly = false)
    public News updateByNewsId(Integer id){
        News news = newsMapper.selectByPrimaryKey(id);
        String s="啊天气不好";
        news.setContent(s);
     newsMapper.updateByPrimaryKeySelective(news);
    String key=Cache+"news:"+id;
    String jsonstr=redisTemplate.boundValueOps(key).get();
    if(jsonstr!=null){
        System.out.println("缓存中存在，更新缓存中的数据");
        redisTemplate.boundValueOps(key).set(s);
        return news;
    }
    System.out.println("缓存中不存在，加入缓存");
    redisTemplate.boundValueOps(key).set(s);
    return news;
}

@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
   public boolean deleteByNewsId(Integer id){
    newsMapper.deleteByPrimaryKey(id);
    String key=Cache+"news:"+id;
    String jsonstr = redisTemplate.boundValueOps(key).get();
    if(jsonstr!=null){
        System.out.println("redis缓存中有数据");
        redisTemplate.delete(key);
        return true;
    }
    return true;
}
}
