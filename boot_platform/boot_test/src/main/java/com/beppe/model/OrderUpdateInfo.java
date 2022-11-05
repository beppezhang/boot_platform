package com.beppe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateInfo {

    private Integer updateType;

    private Long orderId;

    private List<OrderItemInfo> orderItemInfo;

    private String operator;

    private String updateReason;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItemInfo{

        private List<String> logisticNo;  // 物流单号

        private List<String> origLogisticNo; // 原始物流单号

        private Long orderItemId;
    }
}
