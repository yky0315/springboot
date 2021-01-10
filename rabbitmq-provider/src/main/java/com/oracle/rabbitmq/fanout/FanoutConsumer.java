package com.oracle.rabbitmq.fanout;
import com.oracle.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import java.io.IOException;
public class FanoutConsumer {
    private static final String FANOUT_EXCHANGE_NAME="MY_FANOUT_EXCHANGE";
    private static final String FANOUT_QUEUE_NAME="MY_FANOUT_QUEUE3";
    /*
    * fanout类型先有消费方进行等待广播 （消费者去声明交换机  生产者只需要根据交换机进行消息投递，不需要再进行队列的声明）
    * 如果先有生产者 那么消费方是不会接收生产者之前的任何消息（生产者在声明交换机与队列进行过绑定）
    * 如果先有生产者  没有任何消费方队列进行绑定的话 那么消费方启动后不会消费任何消息
    * */
    public static void main(String[] args){
        Connection connection=null;
        Channel channel=null;
        try {
            connection = ConnectionUtils.getConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(FANOUT_EXCHANGE_NAME, "direct", false, false, false, null);
            channel.queueDeclare(FANOUT_QUEUE_NAME, false, false, false, null);
            //只要队列与fanout的交换机绑定   就会广播
            channel.queueBind(FANOUT_QUEUE_NAME, FANOUT_EXCHANGE_NAME, "");
            //创建消费对象  需要指定一个信道
            QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
            //消费方获取消息时 需要指定一个是否为消息的自动确认(true)     手动false
            channel.basicConsume(FANOUT_QUEUE_NAME, false, queueingConsumer);
           while(true){
               QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
               System.out.println(new String(delivery.getBody()));
               //手动确认
               channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
           }
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
