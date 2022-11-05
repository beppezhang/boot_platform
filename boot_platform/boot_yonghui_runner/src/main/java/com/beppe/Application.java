package com.beppe;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author beppe
 * @data 2020/7/27 14:59
 * @description :
 */
@SpringBootApplication
@EnableDubbo
public class Application {

    public static void main(String[] args) {
        System.out.println("启动spring");
        SpringApplication.run(Application.class, args);
    }
}
