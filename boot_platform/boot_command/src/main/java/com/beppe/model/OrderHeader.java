package com.beppe.model;

public class OrderHeader {

    private Long id;

    private String name;

    private String orderStatus;

    private String customerName;

    private String customerPhone;

    private String orderAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(String orderAt) {
        this.orderAt = orderAt;
    }
}
