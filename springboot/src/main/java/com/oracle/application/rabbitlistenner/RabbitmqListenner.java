package com.oracle.application.rabbitlistenner;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class RabbitmqListenner {
    @RabbitListener(queues = "springBootQueue")
    @RabbitHandler
    public void getMessage(Message message){
        System.out.println(new String(message.getBody()));
    }
}
