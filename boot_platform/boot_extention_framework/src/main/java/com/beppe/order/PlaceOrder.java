package com.beppe.order;

import com.beppe.common.ActionCodeEnum;
import com.beppe.common.OrderEntity;
import com.beppe.common.OrderExecContext;
import com.beppe.executor.ActionStepExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 预览订单
@Component
public class PlaceOrder {

    private final ActionStepExecutor actionStepExecutor;

    @Autowired
    public PlaceOrder(ActionStepExecutor actionStepExecutor) {
        this.actionStepExecutor = actionStepExecutor;
    }

    public String place(String operator, OrderEntity orderEntity){
        // 构造订单预览行为事件
        OrderExecContext orderExecContext=OrderExecContext.builder().operator(operator)
                .actionCode(ActionCodeEnum.PLACE_ORDER.getCode())
                .orderEntity(orderEntity)
                .build();
        // 流程编排框架执行方法
        actionStepExecutor.execute(orderExecContext);
        return "success";
    }
}
