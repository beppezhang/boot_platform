package com.beppe.kafka.model;

public class OrderDelivery {

    private Long id;

    private String receiverName;

    private String getReceiverPhone;

    private String customerAddr;

    private String delType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getGetReceiverPhone() {
        return getReceiverPhone;
    }

    public void setGetReceiverPhone(String getReceiverPhone) {
        this.getReceiverPhone = getReceiverPhone;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public String getDelType() {
        return delType;
    }

    public void setDelType(String delType) {
        this.delType = delType;
    }
}
