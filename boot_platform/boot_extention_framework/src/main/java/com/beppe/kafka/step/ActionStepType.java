package com.beppe.kafka.step;

/**
 * 行为步骤
 */
public class ActionStepType {
    /**
     * 预览订单
     */
    public static final String AS_PLACE_ORDER = "AS_PLACE_ORDER";

    /**
     * 创建订单
     */
    public static final String AS_CREATE_ORDER = "AS_CREATE_ORDER";

    /**
     * 支付完成
     */
    public static final String AS_PAYMENT_OK = "AS_PAYMENT_OK";
    /**
     * 取消订单
     */
    public static final String AS_CANCEL_ORDER = "AS_CANCEL_ORDER";
}
