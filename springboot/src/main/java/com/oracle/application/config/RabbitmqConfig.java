package com.oracle.application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue springBootQueue(){
        return new Queue("springBootQueue");
    }
    @Bean
    public DirectExchange springBootExchange(){
        return new DirectExchange("springBootExchange");
    }
    @Bean
    public Binding queueExchangeBind(){
        return BindingBuilder.bind(springBootQueue()).to(springBootExchange()).with("MQ");
    }
}
