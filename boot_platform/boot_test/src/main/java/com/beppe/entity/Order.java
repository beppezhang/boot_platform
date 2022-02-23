package com.beppe.entity;

public class Order {

    private int id;

    private String name;

    private OrderHeader header;

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

    public OrderHeader getHeader() {
        return header;
    }

    public void setHeader(OrderHeader header) {
        this.header = header;
    }
}
