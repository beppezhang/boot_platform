package com.beppe.model;

public enum MyEnum {

    U("上架中"),
    T("临时停售"),
    D("汰换完成"),
    C("汰换中"),
    N("新品试销"),
    A("正常经营");

    private final String desc;

    private MyEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}
