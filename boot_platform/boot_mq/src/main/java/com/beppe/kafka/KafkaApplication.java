package com.beppe.kafka;

import com.beppe.kafka.client.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author beppe
 * @data 2020/12/16 16:53
 * @description :
 */
@SpringBootApplication
public class KafkaApplication {

    @Autowired
    private Product product;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            product.send("beppe" + i);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
