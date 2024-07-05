package com.beppe.proxy.common;

/**
 * 次日达拆单策略
 */
public class NextDaySplitStrategy implements SplitStrategy{

    @Override
    public void split() {
        System.out.println("进入次日达拆单！！");
    }
}
