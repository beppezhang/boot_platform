package com.beppe.kafka.common;

import com.beppe.kafka.entity.Order;
import lombok.Builder;
import lombok.Data;

/**
 * 订单上下文
 */
@Data
@Builder
public class OrderContext {

    private Order order;
}
