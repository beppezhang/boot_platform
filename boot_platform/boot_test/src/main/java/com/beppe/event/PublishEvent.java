package com.beppe.event;

import com.beppe.model.OrderUpdateInfo;
import org.springframework.context.ApplicationEvent;


public class PublishEvent extends ApplicationEvent {

    private OrderUpdateInfo orderUpdateInfo;

    public PublishEvent(Object source,OrderUpdateInfo orderUpdateInfo) {
        super(source);
        this.orderUpdateInfo=orderUpdateInfo;
    }

    public OrderUpdateInfo getOrderUpdateInfo(){
        return orderUpdateInfo;
    }
}
