package com.beppe.kafka.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author beppe
 * @data 2020/8/8 15:56
 * @description :
 */
@RestController
@RequestMapping("send")
public class SenderController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String sendMsg() {
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend("beppe", "第" + i + "个消息");
        }
        return "ok";
    }
}
