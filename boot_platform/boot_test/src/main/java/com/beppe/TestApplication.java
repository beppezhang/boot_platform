package com.beppe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author beppe
 * @data 2021/6/17 14:59
 * @description : dubbo 生产者启动类
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
