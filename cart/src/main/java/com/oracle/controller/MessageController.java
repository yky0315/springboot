package com.oracle.controller;
import com.oracle.service.serviceImpl.MessageServiceImpl;
import com.oracle.utils.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.concurrent.TimeUnit;
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @RequestMapping("/send")
    @ResponseBody
    public boolean  send(String key){
        String code = CodeUtil.getCheckCode();
        boolean flag = messageService.sendMobileTest(code);
        redisTemplate.boundValueOps(key).set(code,60 ,TimeUnit.SECONDS );
        return  flag;
    }
}
