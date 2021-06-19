package com.beppe.model;

import java.io.Serializable;

/**
 * @author beppe
 * @data 2020/9/2 15:45
 * @description : 数据库对象
 */
public class User implements Serializable {

    private static final long serialVersionUID = -864026603758671556L;

    private String username;

    private String password;

    private String realName;

    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
