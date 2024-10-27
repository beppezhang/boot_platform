package com.beppe.kafka.common;/**
 * @description
 * @author Mon co
 * @time 2021/4/28 4:54 下午
 */

/**
 * @author Mon co
 * @description
 * @time 2021/4/28 4:54 下午
 */
public abstract class CommonServiceImpl implements CommonService {


    /**
     * 执行方法
     *
     * @description:
     * @return:
     * @author: Mon co
     * @time: 2021/4/28 5:09 下午
     */
    protected abstract void execute();


    @Override
    public String print(String msg) {
        System.out.println(msg);
        execute();
        return "msg";
    }
}
