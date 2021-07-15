package com.beppe.common;

public enum  MyEnum {

    MALL(1L,"次日达商城（已废弃）"),

    HYD(2L,"永辉生活"),

    BRAVO(3L,"永辉超市"),

    CSX(4L,"彩食鲜"),

    BRAVO_JB(5L,"Bravo精标店");

    private long value;
    private String description;

    private MyEnum(long value, String description) {
        this.value = value;
        this.description = description;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
