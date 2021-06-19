package com.beppe.service;

import com.beppe.iservice.OrderSerice;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(methods = {
        @Method(name = "createOrder",timeout = 90)
},version = "1.0.0")
public class OrderSericeImpl implements OrderSerice {

    @Override
    public void createOrder() throws InterruptedException {
        Thread.sleep(50);
        System.out.println("创建订单");
    }
}
