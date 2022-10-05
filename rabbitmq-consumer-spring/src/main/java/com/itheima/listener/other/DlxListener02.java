package com.itheima.listener.other;

/*
@author YG
@create 2022/10/5   13:47
*/


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * dlx
 */
@Component
public class DlxListener02 implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(3000);
        try {
            System.out.println(new String(message.getBody()));
            int i = 3/0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            System.out.println("消息异常....");
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),true,false);
        }
    }
}
