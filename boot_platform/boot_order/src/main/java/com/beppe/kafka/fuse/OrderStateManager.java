package com.beppe.kafka.fuse;

/**
 * @author Mon co
 * @description 订单状态管理
 * @time 2021/4/30 11:33 上午
 */
public interface OrderStateManager {


    boolean fireTransition(OrderEvent orderEvent);

}
