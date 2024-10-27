package com.beppe.kafka.constant;

import com.beppe.kafka.common.OrderContext;

public class OrderEventImpl{

    String eventId;

    OrderContext orderContext;


    public OrderEventImpl(String eventId, OrderContext orderContext) {
        this.eventId = eventId;
        this.orderContext = orderContext;
    }

    public String getEventId() {
        return eventId;
    }



    public OrderContext getOrderContext() {
        return orderContext;
    }

    public void setOrderContext(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
}
