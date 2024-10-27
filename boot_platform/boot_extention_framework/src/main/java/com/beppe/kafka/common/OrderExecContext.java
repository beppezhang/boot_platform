package com.beppe.kafka.common;

import lombok.Builder;
import lombok.Data;

// 订单执行上下文
@Data
@Builder
public class OrderExecContext implements DomainModel{

    /**
     * 行为编码 (执行动作)
     */
    private String actionCode;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 领域对象
     */
    private OrderEntity orderEntity;

    /**
     * 订单id
     */
    private Long orderId;
}
