package com.beppe.service;

import com.beppe.common.OrderContext;
import com.beppe.constant.OrderEvent;
import com.beppe.constant.OrderEventImpl;
import com.beppe.constant.OrderStatusEnum;
import com.beppe.core.OrderStateManager;
import com.beppe.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderStateManager orderStateManager;

    @Override
    public void createOrder(Order order) {

        OrderEventImpl orderEvent = new OrderEventImpl(OrderEvent.EVT_CREATE_ORDER, OrderContext.builder().order(order).build());
        orderStateManager.handleEvent(orderEvent);
    }

    @Override
    public void cancelOrder(Order order) {

    }

    @Override
    public void shipment(Order order) {

    }
}
