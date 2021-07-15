package com.beppe.common;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

public enum OrderStatus {

    IN_PROGRESS("in.progress", "正在处理"),
    CANCELLED("cancelled", "已取消"),
    SHIPPING("shipping", "送货中"),
    COMPLETED("completed", "已完成"),
    REFUNDING("refunding", "退款审核中"),
    RETURNING("returning", "退货审核中"),
    REFUNDED_COMPLETED("refund.completed", "已退款");

    private String value;
    private String description;

    private static List<OrderStatus> VALUES = EnumUtils.getEnumList(OrderStatus.class);

    private OrderStatus(String value, String description) {
        this.value = "os." + value;
        this.description = description;
    }

    public static OrderStatus getOrderStatus(String value) {
        Iterator var1 = VALUES.iterator();

        OrderStatus orderStatus;
        do {
            if (!var1.hasNext()) {
                throw new RuntimeException(value);
            }

            orderStatus = (OrderStatus)var1.next();
        } while(!StringUtils.equals(orderStatus.getValue(), value));

        return orderStatus;
    }

    public String getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }


}
