package com.beppe.fuse;

/**
 * @author Mon co
 * @description 订单事件处理handler
 * @time 2021/4/30 11:37 上午
 */
public interface OrderEventHandler {

    boolean handle(OrderEvent orderEvent);

}
