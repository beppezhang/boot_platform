package com.beppe.service.impl;

import com.beppe.model.OrderEntity;
import com.beppe.fuse.OrderEvent;
import com.beppe.fuse.OrderStateManager;
import com.beppe.impl.OrderEventImpl;
import com.beppe.service.OrderMakeUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Mon co
 * @description
 * @time 2021/5/6 8:01 下午
 */
@Service
public class OrderMakeUpServiceImpl implements OrderMakeUpService {

    @Autowired
    OrderStateManager orderStateManager;

    @Override
    public OrderEntity confirmOrder(OrderEntity orderEntity) {

        OrderEvent orderEvent = new OrderEventImpl("create.order", "create.order",
                new OrderEntity());
        orderEvent.setParameter(OrderEvent.EVT_CREATE_ORDER, "create Order");
        orderStateManager.fireTransition(orderEvent);
        return null;
    }
}
