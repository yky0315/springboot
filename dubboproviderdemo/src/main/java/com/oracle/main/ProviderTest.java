package com.oracle.main;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
public class ProviderTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
        context.start();  //启动spring容器
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
