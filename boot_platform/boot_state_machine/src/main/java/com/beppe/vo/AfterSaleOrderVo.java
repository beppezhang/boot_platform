package com.beppe.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mon co
 * @description
 * @time 2021/5/27 3:30 下午
 */
@Data
public class AfterSaleOrderVo implements Serializable {

    private static final long serialVersionUID = -3457976175291478355L;

    private String id;

    private String orderId;

}
