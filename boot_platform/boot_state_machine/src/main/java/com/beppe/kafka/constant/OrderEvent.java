package com.beppe.kafka.constant;

/**
 *  订单事件   事件触发订单状态更改
 */
public class OrderEvent {

    //  创建
    public static final String EVT_CREATE_ORDER = "create";

    // 支付
    public static final String EVT_PEYMENT_ORDER = "payment";

    // 取消
    public static final String EVT_CANCEL_ORDER = "cancel";

    // 发货
    public static final String EVT_SHIPPEMNT_ORDER = "shippment";





}
