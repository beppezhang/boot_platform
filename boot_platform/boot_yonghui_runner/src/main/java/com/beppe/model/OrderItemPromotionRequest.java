package com.beppe.model;

import com.yonghui.trade.model.OrderHeader;
import com.yonghui.trade.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangsl
 * @description
 * @time 2022-03-29
 * @desc 计算单品级别促销入参
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPromotionRequest implements Serializable {

    private static final long serialVersionUID = 2797382345907351336L;

    // 商品行列表
    private List<OrderItem> orderItems;

    private OrderHeader orderHeader;

    // 是否计算促销扣款  true 计算
    private boolean evaluate;

    private String calculateType;
}
