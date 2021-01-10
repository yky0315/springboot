package com.oracle.test;
import com.alibaba.fastjson.JSONObject;
import com.oracle.mapper.ProductMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.List;
public class ProductTest extends BaseTest {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    String key="product_cache";
    @Test
    @Before
    public void productData(){
        List<Product> products = productMapper.selectProduct(10);
        String jsonstr = JSONObject.toJSONString(products);
        redisTemplate.boundValueOps(key).set(jsonstr);
    }
    @Test
    @After
    public void getProduct(){
        String jsonstr = redisTemplate.boundValueOps(key).get();
        if(jsonstr!=null){
            List<Product> prolist = JSONObject.parseArray(jsonstr, Product.class);
            for (Product p: prolist) {
                System.out.println(p);
            }
        }
    }
}
