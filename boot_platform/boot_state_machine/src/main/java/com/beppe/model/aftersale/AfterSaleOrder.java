package com.beppe.model.aftersale;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mon co
 * @description 售后单基本信息
 * @time 2021/5/27 3:26 下午
 */
@Data
public class AfterSaleOrder implements Serializable {

    private static final long serialVersionUID = -6209312951288691928L;

    private String id;

    private String orderId;
}
