package com.beppe.receiver;

import com.beppe.util.ThreadLocalUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author beppe
 * @data 2020/8/8 15:51
 * @description : 消息监听
 */
@Slf4j
@Component
public class ReceiverListener {

    @RabbitHandler
    @RabbitListener(queues = "beppe")
    public void receiveMsg(Message message, Channel channel) throws InterruptedException, IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println(Thread.currentThread() + "start");
        ThreadLocalUtil.set(message.toString());
        System.out.println(Thread.currentThread() + ThreadLocalUtil.get());
        System.out.println(Thread.currentThread() + ThreadLocalUtil.get());
        System.out.println(Thread.currentThread() + "end");
    }
}
