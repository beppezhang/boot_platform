package com.beppe.kafka.contrller;

import com.beppe.kafka.constant.OrderStatusEnum;
import com.beppe.kafka.entity.Order;
import com.beppe.kafka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @RequestMapping("create")
    public void createOrder(Long orderId){
        System.out.println("orderId:"+orderId);
        Order order = Order.builder().orderStatus(OrderStatusEnum.CREATE_EVENT.status).phone("156888822").address("shaghai").build();
        orderService.createOrder(order);
    }

    @RequestMapping("payment")
    public void payment(){
        Order order = Order.builder().orderStatus(OrderStatusEnum.FORMAL_EVENT.status).phone("156888822").address("shaghai").build();
        orderService.createOrder(order);
    }
}