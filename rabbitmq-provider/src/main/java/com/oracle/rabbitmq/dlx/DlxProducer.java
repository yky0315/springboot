package com.oracle.rabbitmq.dlx;
import com.oracle.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.HashMap;
public class DlxProducer {
    private static final String DIRECT_EXCHANGE_NAME="MY_DIRECT_EXCHANGE";
    private static final String DIRECT_QUEUE_NAME="MY_DIRECT_QUEUE";
    private static final String routingKey="DIRECT_KEY";
    public static void main(String[] args) {
        Connection connection=null;
        Channel channel=null;
        try {
            connection = ConnectionUtils.getConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct", false, false, false, null);
            HashMap hashMap = new HashMap();
            //设置过期时间
            hashMap.put("x-message-ttl", 5000);
            //       x-dead-letter-exchange    声明  死信队列Exchange
            hashMap.put("x-dead-letter-exchange", "DEAD_LETTER_EXCHANGE");
            //    x-dead-letter-routing-key    声明 死信队列抛出异常重定向队列的routingKey(TKEY_R)  可以不设置
            hashMap.put("x-dead-letter-routing-key", "");
            channel.queueDeclare(DIRECT_QUEUE_NAME, false, false, false, hashMap);
            //交换机与队列直接绑定关系
            channel.queueBind(DIRECT_QUEUE_NAME, DIRECT_EXCHANGE_NAME, routingKey);
            //消息发送  发消息并不是直接投递给队列 先交给交换机 交换机根据发送是的routingkey进行路由投递到与交换机绑定的队列中
                String message="这是一个消息,5秒后，进入死信队列";
                channel.basicPublish(DIRECT_EXCHANGE_NAME, routingKey, null, message.getBytes());
            System.out.println("消息已经发送");
        } catch (IOException e) {
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
