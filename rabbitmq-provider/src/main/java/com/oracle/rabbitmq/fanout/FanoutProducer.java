package com.oracle.rabbitmq.fanout;
import com.oracle.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
public class FanoutProducer {
    private static final String FANOUT_EXCHANGE_NAME="MY_FANOUT_EXCHANGE";

    /*
     * fanout类型先有消费方进行等待广播 （消费者去声明交换机  生产者只需要根据交换机进行消息投递，不需要再进行队列的声明）
     * 如果先有生产者 那么消费方是不会接收生产者之前的任何消息（生产者在声明交换机与队列进行过绑定）
     * 只要队列与fanout的交换机绑定   就会广播
     * 如果先有生产者  没有任何消费方队列进行绑定的话 那么消费方启动后不会消费任何消息
     * */
    public static void main(String[] args){
        Connection connection=null;
        Channel channel=null;
        try {
            connection = ConnectionUtils.getConnection();
            channel = connection.createChannel();
            channel.basicPublish(FANOUT_EXCHANGE_NAME, "", null, "这是fanout消息发送".getBytes());
            System.out.println("消息发送成功");
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
