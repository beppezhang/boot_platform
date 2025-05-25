package com.beppe.kafka.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private int id;

    private String name;

    private int parentId;

    private transient BigDecimal amout;

    private List<OrderHeader> headers;

    private List<Pair<String,String>> pairs;

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

    public List<OrderHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<OrderHeader> headers) {
        this.headers = headers;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getAmout() {
        return amout;
    }

    public void setAmout(BigDecimal amout) {
        this.amout = amout;
    }

    @JsonIgnore
    @JSONField(serialize = false)
    public List<Pair<String, String>> getPairs() {
        return pairs;
    }

    @JsonIgnore
    @JSONField(serialize = false)
    public void setPairs(List<Pair<String, String>> pairs) {
        this.pairs = pairs;
    }




}
