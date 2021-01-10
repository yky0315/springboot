package com.oracle.rabbitmq.direct.consumer;
import com.oracle.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
public class RabbitmqConsumer {
    private static final String DIRECT_EXCHANGE_NAME="MY_DIRECT_EXCHANGE";
    private static final String DIRECT_QUEUE_NAME="MY_DIRECT_QUEUE";
    private static final String routingKey="DIRECT_KEY";
    public static void main(String[] args){
        Connection connection=null;
        Channel channel=null;
        try {
             connection = ConnectionUtils.getConnection();
             channel = connection.createChannel();
             channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct", false, false, false, null);
             channel.queueDeclare(DIRECT_QUEUE_NAME, false, false, false, null);
             channel.queueBind(DIRECT_QUEUE_NAME, DIRECT_EXCHANGE_NAME, routingKey);
             //最多处理未消费一条   消费完一条处理一条
             channel.basicQos(1);
             //创建消费对象  需要指定一个信道
             QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
             //消费方获取消息时 需要指定一个是否为消息的自动确认(true)     手动false
             channel.basicConsume(DIRECT_QUEUE_NAME, false, queueingConsumer);

            for (int i = 1; i <=100 ; i++) {
                //获取消息
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                System.out.println(new String(delivery.getBody()));
                //手动确认
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
            //休眠
            Thread.sleep(800);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
