package com.beppe.entity;

import com.beppe.common.EventConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个user对象 关注   create   cancel
*/
public class User1 implements Strategy{

    public List<String> getStrategy(){
        List<String> list=new ArrayList<>();
        list.add(EventConstant.CREATE);
        list.add(EventConstant.CANCEL);
        return list;
    }

    public String getName(){
        return "user1";
    }
}
