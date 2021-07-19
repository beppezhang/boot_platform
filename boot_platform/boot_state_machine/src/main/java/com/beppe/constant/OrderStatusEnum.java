package com.beppe.constant;

import java.util.Arrays;

/**
 * 订单状态枚举
 */
public enum OrderStatusEnum {

    CREATE_EVENT(1, "临时订单"),
    FORMAL_EVENT(2, "正式订单"),
    PAY_DONE(3, "已支付"),
    ORDER_FINISHED(4, "订单已完成"),
    ORDER_CANCEL(5, "订单已取消"),
    ORDER_SHIPMENT_OK(6, "订单已发货");

    OrderStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static OrderStatusEnum getEnum(int status){
        OrderStatusEnum[] values = OrderStatusEnum.values();
        for (OrderStatusEnum v:values){
            if(status==v.status){
                return v;
            }
        }
        return null;
    }

    public int status;

    public String desc;
}
