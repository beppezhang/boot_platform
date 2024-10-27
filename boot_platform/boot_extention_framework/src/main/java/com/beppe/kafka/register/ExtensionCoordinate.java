package com.beppe.kafka.register;

import java.util.Objects;

/**
 *  扩展点坐标
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtensionCoordinate that = (ExtensionCoordinate) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(point, that.point) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, point, code);
    }

    @Override
    public String toString() {
        return "ExtensionCoordinate{" +
                "type='" + type + '\'' +
                ", point='" + point + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
