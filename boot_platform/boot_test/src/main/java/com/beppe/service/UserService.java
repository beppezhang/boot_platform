package com.beppe.service;

import com.beppe.entity.Order;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractUserService {



    public void create(){
        doSer();
    }

//    @Cacheable(value = "UserService-getShopById", key = "#p0")
    public Order getUser(String userId) {
        System.out.println("userId:"+userId);
        Order order = new Order();
        order.setName(userId);
        System.out.println("进入新建");
        return order;

    }
}
