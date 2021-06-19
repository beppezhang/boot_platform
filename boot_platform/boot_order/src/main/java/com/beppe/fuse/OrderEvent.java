package com.beppe.fuse;

import com.beppe.order.OrderCommandContext;

/**
 * @author Mon co
 * @description 订单事件接口
 * @time 2021/4/30 11:37 上午
 */
public interface OrderEvent {


    String EVT_CREATE_ORDER = "oe.create";

    boolean handle(OrderEvent orderEvent);

    String getEventId();

    OrderCommandContext getOrderCommandContext();

    void setParameter(String eventKey, Object obj);

    Object getParameter(String eventKey);
}
