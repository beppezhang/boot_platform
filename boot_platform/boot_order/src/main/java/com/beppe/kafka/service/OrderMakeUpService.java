package com.beppe.kafka.service;

import com.beppe.kafka.model.OrderEntity;

/**
 * @author Mon co
 * @description 任务编排
 * @time 2021/5/6 7:56 下午
 */
public interface OrderMakeUpService {

    /**
     * 确认订单
     *
     * @param orderEntity
     * @return OrderEntity
     */
    OrderEntity confirmOrder(OrderEntity orderEntity);
}
