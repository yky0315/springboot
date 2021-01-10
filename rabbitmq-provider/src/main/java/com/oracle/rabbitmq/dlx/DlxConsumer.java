package com.oracle.rabbitmq.dlx;
import com.oracle.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import java.io.IOException;
/*
* 死信队列就是普通的队列，在生产者发送消息，没有消费者消费超时的情况下，消息会被拉到死信队列，通过与生产者绑定交换机*/
public class DlxConsumer {
    private static final String DEAD_LETTER_EXCHANGE="DEAD_LETTER_EXCHANGE";
    private static final String DIRECT_QUEUE_NAME="DEL-QUEUE";
    private static final String routing_key="";
    public static void main(String[] args){
        Connection connection=null;
        Channel channel=null;
        try {
            connection = ConnectionUtils.getConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(DEAD_LETTER_EXCHANGE, "direct", false, false, false, null);
            channel.queueDeclare(DIRECT_QUEUE_NAME, false, false, false, null);
            channel.queueBind(DIRECT_QUEUE_NAME, DEAD_LETTER_EXCHANGE, "");
            //创建消费对象  需要指定一个信道
            QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
            //消费方获取消息时 需要指定一个是否为消息的自动确认(true)     手动false
            channel.basicConsume(DIRECT_QUEUE_NAME, false, queueingConsumer);
                //获取消息
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                System.out.println(new String(delivery.getBody()));
                //手动确认
                //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
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
