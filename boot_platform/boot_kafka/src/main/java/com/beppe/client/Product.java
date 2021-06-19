package com.beppe.client;

import com.alibaba.fastjson.JSON;
import com.beppe.bean.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author beppe
 * @data 2020/12/16 16:58
 * @description :
 */
@Component
public class Product {

    @Resource
    private KafkaTemplate kafkaTemplate;

    public void send(String name) {
        User u = new User();
        u.setId(11);
        u.setUsername(name);
        try {
            kafkaTemplate.send("beppe", JSON.toJSONString(u));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        kafkaTemplate.send("test_topic", JSON.toJSONString(u));

//        kafkaTemplate.send("user", JSON.toJSONString(u));
    }
}
