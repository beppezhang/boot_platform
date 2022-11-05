package com.beppe.service;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractUserService {

    @Autowired
    private OrderServiceImpl orderService;

    public void doSer(){
        orderService.doCal();
    }


}
