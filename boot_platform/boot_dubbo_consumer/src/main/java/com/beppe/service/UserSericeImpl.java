package com.beppe.service;

import com.beppe.iservice.OrderSerice;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSericeImpl implements IUserService{

    @Reference(version = "1.0.0")
    OrderSerice orderSerice;

    @Override
    public void buyGoods() throws InterruptedException {
        orderSerice.createOrder();
    }
}
