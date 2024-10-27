package com.beppe.kafka.entity;

public class OrderDTO {

    private int id;

    private String name;

    private OrderHeaderDTO headerDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderHeaderDTO getHeaderDTO() {
        return headerDTO;
    }

    public void setHeaderDTO(OrderHeaderDTO headerDTO) {
        this.headerDTO = headerDTO;
    }
}
