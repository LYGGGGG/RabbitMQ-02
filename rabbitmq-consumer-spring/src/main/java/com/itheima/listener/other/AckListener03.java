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
 * 在 rabbit:listener container 标签中设置 acknowledge 属性，设置 ack 方式 none
 * 手动确认
 */
@Component
public class AckListener03 implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        Thread.sleep(3000);
        try {
            System.out.println(new String(message.getBody()));
            System.out.println("处理业务...");
            int i = 3/0;
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            channel.basicNack(deliveryTag, true, true);
        }

    }
}
