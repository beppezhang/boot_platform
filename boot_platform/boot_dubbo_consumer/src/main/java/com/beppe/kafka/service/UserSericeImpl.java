package com.beppe.kafka.service;

import com.beppe.kafka.iservice.OrderSerice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserSericeImpl implements IUserService{

    @Reference(version = "1.0.0",url="dubbo://127.0.0.1:20880")
    OrderSerice orderSerice;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public String buyGoods() throws InterruptedException {
        orderSerice.createOrder();
        return "hello world";
    }

    public String hello(){
        return "fallback value";
    }
}
