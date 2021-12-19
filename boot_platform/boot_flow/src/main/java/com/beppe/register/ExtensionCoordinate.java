package com.beppe.register;

import java.util.Objects;

/**
 * 扩展点坐标
 *   类型
 *   坐标点
 *   编码
 */
public class ExtensionCoordinate {

    private String type;

    private String point;

    private String code;

    public ExtensionCoordinate(String type, String point, String code) {
        this.type = type;
        this.point = point;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type,point,code);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)  return true;
        if(obj==null || this.getClass()!= obj.getClass()) return false;
        ExtensionCoordinate coordinate=(ExtensionCoordinate)obj;
        return Objects.equals(type,coordinate.getType())&&
                Objects.equals(code,coordinate.getCode())&&
                Objects.equals(point,coordinate.getPoint());
    }
}
