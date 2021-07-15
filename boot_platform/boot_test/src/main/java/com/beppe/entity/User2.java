package com.beppe.entity;

import com.beppe.common.EventConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个user对象 关注   payok   cancel
 */
public class User2 implements Strategy {

    public List<String> getStrategy(){
        List<String> list=new ArrayList<>();
        list.add(EventConstant.PAYOK);
        list.add(EventConstant.CANCEL);
        return list;
    }

    public String getName(){
        return "user2";
    }
}
