package com.beppe.statemachine.enumerate;

/**
 * @author Mon co
 * @description
 * @time 2021/5/27 8:08 下午
 */
public enum OrderStates {

    /**
     * 未处理
     */
    UNPROCESSED,

    /**
     * 处理中
     */
    IN_PROCESS,

    /**
     * 处理通过
     */
    PASS_PROCESS,

    /**
     * 拒绝
     */
    REJECT_APPROVE,

    /**
     * 退款中
     */
    IN_REFUNDING,

    /**
     * 退款失败
     */
    REFUND_FAILURE,

    /**
     * 退款成功
     */
    REFUND_SUCCESS,

    /**
     * 现金退款中
     */
    CASH_REFUNDING,

    /**
     * 现金审核中
     */
    CASH_APPROVE,

    /**
     * 审核通过
     */
    CASH_APPROVE_SUCCESS,

    /**
     * 结束流程
     */
    END;

}
