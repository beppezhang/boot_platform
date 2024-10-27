package com.beppe.kafka.model;

import java.io.Serializable;

/**
 * @author beppe
 * @data 2021/1/14 11:19
 * @description :
 */
public class Classes implements Serializable {

    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
