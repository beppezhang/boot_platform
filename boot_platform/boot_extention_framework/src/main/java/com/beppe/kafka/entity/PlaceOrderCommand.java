package com.beppe.kafka.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PlaceOrderCommand {

    /**
     * 门店id
     */
    private String shopId;

    /**
     * 设备编码
     */
    private String deviceCode;

    /**
     * 操作人id
     */
    private Long salesClerkId;

    /**
     * 类型
     */
    private String type;

    /**
     * 渠道id
     */
    private Integer saleChannelId;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 会员id
     */
    private Long customerId;
}
