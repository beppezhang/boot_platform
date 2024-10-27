package com.beppe.kafka;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author beppe
 * @data 2021/6/17 14:59
 * @description : dubbo 生产者启动类
 */
@SpringBootApplication
@EnableDubbo
@EnableHystrix
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
