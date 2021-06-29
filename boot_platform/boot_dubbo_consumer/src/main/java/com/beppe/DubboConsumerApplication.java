package com.beppe;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author beppe
 * @data 2020/7/27 14:59
 * @description : dubbo 消费者启动类
 */
@SpringBootApplication
@EnableHystrix
@EnableDubbo
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}
