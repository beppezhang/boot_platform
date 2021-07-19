package com.beppe.common;

import com.beppe.entity.Order;
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
