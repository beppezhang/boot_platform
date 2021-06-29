package com.beppe.order;

import com.beppe.common.ActionCodeEnum;
import com.beppe.common.OrderEntity;
import com.beppe.common.OrderExecContext;

// 预览订单
public class PlaceOrder {

    public String place(String operator, OrderEntity orderEntity){
        // 构造订单预览行为
        OrderExecContext.builder().operator(operator)
                .actionCode(ActionCodeEnum.PLACE_ORDER.getCode())
                .orderEntity(orderEntity)
                .build();
        // 流程编排框架执行方法

        return null;
    }
}
