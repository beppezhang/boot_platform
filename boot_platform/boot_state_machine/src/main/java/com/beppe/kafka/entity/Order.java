package com.beppe.kafka.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private Long id;

    private int orderStatus;

    private String phone;

    private String address;
}
