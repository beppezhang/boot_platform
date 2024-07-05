package com.beppe.utils;

import java.util.function.Supplier;

public class Myutil {

    public static String execute(String request, Supplier supplier){
        Object o=supplier.get();
        return ((String) o)+request;
    }
}
