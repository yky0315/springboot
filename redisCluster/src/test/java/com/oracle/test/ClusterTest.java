package com.oracle.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class ClusterTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void test(){
        String key="Culster";
        String val="集群测试";
        redisTemplate.boundValueOps(key).set(val);
    }
}
