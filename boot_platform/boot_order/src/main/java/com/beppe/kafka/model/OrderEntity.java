package com.beppe.kafka.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mon co
 * @description 订单实体类
 * @time 2021/5/6 7:57 下午
 */
@Data
public class OrderEntity implements Serializable {

    /**
     * 订单号 唯一号
     */
    private String orderId;

    /**
     * 订单内部号
     */
    private String orderNo;

    /**
     * 订单外部号
     */
    private String orderNum;


    private OrderHeader orderHeader;
}
