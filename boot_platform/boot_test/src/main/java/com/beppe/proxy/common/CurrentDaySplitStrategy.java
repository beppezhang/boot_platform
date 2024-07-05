package com.beppe.proxy.common;

/**
 * 当日达拆单策略
 */
public class CurrentDaySplitStrategy implements SplitStrategy{

    @Override
    public void split() {
        System.out.println("进入当日达拆单");
    }
}
