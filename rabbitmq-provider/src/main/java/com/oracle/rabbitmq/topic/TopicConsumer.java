package com.oracle.rabbitmq.topic;

import com.oracle.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class TopicConsumer {
    private final static String EXCHANGE_NAME = "topic_exchange";
    private static final String TOPIC_QUEUE_NAME="MY_TOPIC_QUEUE";
    private static final String routingKey="*.info";
    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"topic",false,false,false,null);
        // 声明队列
        channel.queueDeclare(TOPIC_QUEUE_NAME, false, false, false, null);
        // 绑定队列到交换机 *可以代替一个单词
        channel.queueBind(TOPIC_QUEUE_NAME, EXCHANGE_NAME, routingKey);
        // 指该消费者在接收到队列里的消息但没有返回确认结果之前,它不会将新的消息分发给它。
        //channel.basicQos(1);

        //创建消费对象  需要指定一个信道
        Consumer consumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                System.out.println("消费者1收到消息:" + new String(body));
                // 消费者手动发送ack应答
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 关闭通道和连接
        channel.close();
        connection.close();
    }
}
