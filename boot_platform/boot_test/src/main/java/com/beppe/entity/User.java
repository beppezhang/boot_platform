package com.beppe.entity;

import com.beppe.annotation.FieldAnnotion;

public class User {

    private String id;

    @FieldAnnotion
    private String name;

    @FieldAnnotion
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
