package com.beppe.utils;

public class JDKVersion8HashOfLong {

    public JDKVersion8HashOfLong() {
    }

    public static Integer hashCodeV8(long in) {
        return (int)(in ^ in >>> 32);
    }

    public static Integer hashCodeV8(String longStr) {
        return hashCodeV8(Long.parseLong(longStr));
    }
}
