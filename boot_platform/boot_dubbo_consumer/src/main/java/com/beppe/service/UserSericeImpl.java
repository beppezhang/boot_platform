package com.beppe.service;

import com.beppe.iservice.OrderSerice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSericeImpl implements IUserService{

    @Reference(version = "1.0.0")
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
