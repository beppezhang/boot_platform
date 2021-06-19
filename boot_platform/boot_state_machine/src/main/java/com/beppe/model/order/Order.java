package com.beppe.model.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mon co
 * @description 订单基本信息
 * @time 2021/5/27 3:08 下午
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 3974948526187575655L;

    /**
     * 订单头信息
     */
    private OrderHeader orderHeader;

    /**
     * 订单物品信息
     */
    private List<OrderItem> orderItemList;

    /**
     * 订单物流信息
     */
    private OrderDelivery orderDelivery;

    /**
     * 订单支付信息
     */
    private List<OrderPayment> orderPaymentList;

    /**
     * 订单积分信息
     */
    private List<OrderPoint> orderPointList;

    /**
     * 订单促销信息
     */
    private List<OrderCoupon> orderCouponList;


}
