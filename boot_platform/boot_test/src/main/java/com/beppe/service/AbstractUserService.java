package com.beppe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;

public abstract class AbstractUserService {

    @Autowired
    private OrderService orderService;

    public void doSer(){
        orderService.doCal();
    }


}
