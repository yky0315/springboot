package com.oracle.application.controller;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.oracle.application.config.UuidUtil;
import com.oracle.application.entity.Admins;
import com.oracle.application.service.IAdminsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yky
 * @since 2020-12-11
 */
@RestController
@RequestMapping("/admins")
@Slf4j  //logback解合lombok使用
public class AdminsController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private IAdminsService iAdminsService;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private DirectExchange springBootExchange;
      @GetMapping("/getAdminById")
      public Admins getAdminById(Integer id){
          log.info("请求根据id查询admin");
          Admins admin = iAdminsService.getById(id);
          return admin;
      }
      @PostMapping("/add")
      public String add(@RequestBody Admins admin){
          iAdminsService.save(admin);
          return "ok";
      }
      @RequestMapping("/delete")
      public String delete(Integer id){
          iAdminsService.removeById(id);
          return "ok";
      }

      @RequestMapping("/update")
     public String update(@RequestBody Admins admins){
          iAdminsService.updateById(admins);
          return "ok";
      }
      @GetMapping("/setk")
     public String setk(){
          String key="admin";
          Admins admins = new Admins();
          admins.setLoginname("aaa");
          admins.setPwd("aaa");
          admins.setStatus(0);
          String jsonStr = JSONObject.toJSONString(admins);
          redisTemplate.boundValueOps(key).set(jsonStr);
          return jsonStr;
      }

      @GetMapping("/sendMsg")
     public String sendMsg(){
        amqpTemplate.convertAndSend(springBootExchange.getName(), "MQ", "测试SpringBootMQ".getBytes());
        return "ok";
      }

      @GetMapping("/upload")
     public String uploadFile(MultipartFile image){
          String originalFilename = image.getOriginalFilename();
          String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
          String fileName=UuidUtil.getUuid()+suffix;
          OSSClient client = new OSSClient("oss-cn-beijing.aliyuncs.com","LTAI4GHPrU6vsYH7fjaYJ39C","naicT03QxPGYGlSG5QwhU7Gf0JAaFC");
          try {
              client.putObject("springbootuploadyky",fileName, image.getInputStream());
          } catch (IOException e) {
              e.printStackTrace();
          }finally {
              client.shutdown();
          }
        return "ok";
      }
}
