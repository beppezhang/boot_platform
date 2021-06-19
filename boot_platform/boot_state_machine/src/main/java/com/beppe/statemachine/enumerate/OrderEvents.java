package com.beppe.statemachine.enumerate;

/**
 * @author Mon co
 * @description
 * @time 2021/5/27 8:08 下午
 */
public enum OrderEvents {

    /**
     * 点击处理
     */
    DO_PROCESS,

    /**
     * 处理通过
     */
    DO_PASS,

    /**
     * 拒绝
     */
    DO_REJECT,

    /**
     * 开始退款
     */
    DO_REFUND,

    /**
     * 获得退款结果
     */
    DO_GET_REFUND_RESULT,


    ;
}
