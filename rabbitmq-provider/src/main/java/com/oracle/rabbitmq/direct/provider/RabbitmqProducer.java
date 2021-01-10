package com.oracle.rabbitmq.direct.provider;
import com.oracle.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
public class RabbitmqProducer {
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
             channel.queueDeclare(DIRECT_QUEUE_NAME, false, false, false, null);
             //交换机与队列直接绑定关系
             channel.queueBind(DIRECT_QUEUE_NAME, DIRECT_EXCHANGE_NAME, routingKey);
             //消息发送  发消息并不是直接投递给队列 先交给交换机 交换机根据发送是的routingkey进行路由投递到与交换机绑定的队列中
             for (int i = 1; i <=100 ; i++) {
                String message="这是一个消息"+i;
                channel.basicPublish(DIRECT_EXCHANGE_NAME, routingKey, null, message.getBytes());
             }
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
