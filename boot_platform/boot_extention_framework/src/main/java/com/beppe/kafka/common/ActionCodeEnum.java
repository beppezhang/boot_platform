package com.beppe.kafka.common;

/**
 * 行为枚举
 */
public enum  ActionCodeEnum {

    PLACE_ORDER("placeOrder","预览订单"),

    CONFIRM_ORDER("confirmOrder","确认订单"),

    PAYMENT_OK_ORDER("paymentOkOrder","支付完成"),

    CANCEL_ORDER("cancelOrder","取消订单");

    private String code;

    private String desc;

    ActionCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
