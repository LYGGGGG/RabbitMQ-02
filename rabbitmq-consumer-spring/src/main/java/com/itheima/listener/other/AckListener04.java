package com.itheima.listener.other;

/*
@author YG
@create 2022/10/5   13:47
*/


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * 测试单条消息过期时间
 */
@Component
public class AckListener04 implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(5000);
        System.out.println(new String(message.getBody()));
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
        }

    }
}
