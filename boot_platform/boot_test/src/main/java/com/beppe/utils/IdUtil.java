package com.beppe.utils;

import java.util.Random;

public class IdUtil {

    public static long nextId(String s) {
        return new Random().nextLong();
    }
}
