package com.oracle.main;
import com.oracle.service.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ConsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        DubboService dubboService = (DubboService) context.getBean("dubboServiceApi");
        dubboService.save();
    }
}
