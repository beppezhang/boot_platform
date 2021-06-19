package com.beppe.fuse;

/**
 * @author Mon co
 * @description 订单状态监听接口
 * @time 2021/4/30 11:33 上午
 */
public interface OrderStateTransitionListener {

    boolean onEvent(OrderEvent orderEvent);

}
