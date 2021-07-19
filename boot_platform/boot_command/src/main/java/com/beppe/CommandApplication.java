package com.beppe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author beppe
 * @data 2021/6/17 14:59
 * @description : dubbo 生产者启动类
 */
@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }
}
