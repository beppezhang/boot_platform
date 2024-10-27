package com.beppe.kafka.controller;

import com.beppe.kafka.common.OrderEntity;
import com.beppe.kafka.order.PlaceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extention/")
public class PlaceOrderController {

    @Autowired
    private PlaceOrder placeOrder;

    @RequestMapping("placeOrder")
    public String placeOrder() {
        OrderEntity orderEntity = new OrderEntity();
        return placeOrder.place("beppe", orderEntity);
    }
}
