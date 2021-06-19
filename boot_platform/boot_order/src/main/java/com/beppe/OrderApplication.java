package com.beppe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Mon co
 * @description
 * @time 2021/5/7 9:47 上午
 */
@SpringBootApplication
@ImportResource("classpath:orderState-config.xml")
public class OrderApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
