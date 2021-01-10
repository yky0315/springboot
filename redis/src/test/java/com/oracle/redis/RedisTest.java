package com.oracle.redis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    private static  final String CACHE_PREFIX="cache:";
    @Test
    public void testString(){

        String key=CACHE_PREFIX+"abc";
        String value="Stringredis";
        redisTemplate.boundValueOps(key).set(value, 30, TimeUnit.SECONDS);
    }
    @Test
    public void testGetValue(){
        String key=CACHE_PREFIX+"abc";
        Object obj = redisTemplate.boundValueOps(key).get();
        System.out.println(obj);
    }
    @Test
    public void hashTest(){
            String key=CACHE_PREFIX+"user";
            String field="username1";
            String val="zhangsan";
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 99);
        map.put("username", "zhangsan");
        map.put("sex", "男");
        redisTemplate.boundHashOps(key).putAll(map);
    }

    @Test
    public void testList(){
        String key=CACHE_PREFIX+"age";
        Integer val=22;
        redisTemplate.boundListOps(key).leftPush(val);
    }

    @Test
    public void testSet(){
        String key="address";
        String[] value={"北京","上海","广州"};
        redisTemplate.boundSetOps(key).add(value);
    }
}
