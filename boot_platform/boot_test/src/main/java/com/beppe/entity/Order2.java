package com.beppe.entity;

import java.util.List;

public class Order2 {

    private Long id;

    private String code;

    private List<Order1>  list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Order1> getList() {
        return list;
    }

    public void setList(List<Order1> list) {
        this.list = list;
    }
}
