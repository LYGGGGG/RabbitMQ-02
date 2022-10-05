package com.itheima.listener.other;

/*
@author YG
@create 2022/10/5   13:47
*/


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * 在 rabbit:listener container 标签中设置 acknowledge 属性，设置 ack 方式 none
 * 自动确认
 */
@Component
public class AckListener02 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
