package com.beppe.statemachine.config;

import com.beppe.statemachine.enumerate.OrderEvents;
import com.beppe.vo.AfterSaleOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author Mon co
 * @description
 * @time 2021/5/27 8:48 下午
 */
@Slf4j
@WithStateMachine(id = "orderMachine")
public class OrderEventConfig {

    @OnTransition(target = "UNPROCESSED")
    public void doProcess(Message<OrderEvents> message) throws Exception{
        log.info("---售后单创建，待处理---");
//        throw new Exception();
    }

    @OnTransition(source = "UNPROCESSED", target = "IN_PROCESS")
    public void process(Message<OrderEvents> message) {
        AfterSaleOrderVo afterSaleOrderVo = message.getHeaders().get("form", AfterSaleOrderVo.class);
        log.info("---处理中---id : {}, orderId :{}", afterSaleOrderVo.getId(), afterSaleOrderVo.getOrderId());

    }

    @OnTransition(source = "IN_PROCESS", target = "PASS_PROCESS")
    public void pass(Message<OrderEvents> message) {
        AfterSaleOrderVo afterSaleOrderVo = message.getHeaders().get("form", AfterSaleOrderVo.class);
        log.info("---通过审核---id : {}, orderId :{}", afterSaleOrderVo.getId(), afterSaleOrderVo.getOrderId());

    }
}
