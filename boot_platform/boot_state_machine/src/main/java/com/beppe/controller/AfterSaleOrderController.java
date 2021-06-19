package com.beppe.controller;

import com.beppe.model.aftersale.AfterSaleOrder;
import com.beppe.service.AfterSaleOrderService;
import com.beppe.statemachine.OrderStateMachineBuilder;
import com.beppe.statemachine.enumerate.OrderEvents;
import com.beppe.statemachine.enumerate.OrderStates;
import com.beppe.vo.AfterSaleOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mon co
 * @description
 * @time 2021/5/27 8:55 下午
 */
@Slf4j
@RestController
@RequestMapping("/afterSaleOrder")
public class AfterSaleOrderController {

    @Autowired
    private AfterSaleOrderService afterSaleOrderService;

    @Autowired
    private OrderStateMachineBuilder orderStateMachineBuilder;

    @Autowired
    private BeanFactory beanFactory;


    @PostMapping("/create")
    public AfterSaleOrder createAfterSaleOrder(@RequestBody AfterSaleOrderVo afterSaleOrderVo) throws Exception {

        StateMachine<OrderStates, OrderEvents> stateMachine = orderStateMachineBuilder.build(beanFactory);

        log.info(stateMachine.getId());

        stateMachine.start();

        Message message = MessageBuilder.withPayload(OrderEvents.DO_PROCESS).setHeader("form", afterSaleOrderVo).build();
        stateMachine.sendEvent(message);

        message = MessageBuilder.withPayload(OrderEvents.DO_PASS).setHeader("form", afterSaleOrderVo).build();
        stateMachine.sendEvent(message);

        AfterSaleOrder afterSaleOrder = new AfterSaleOrder();
        BeanUtils.copyProperties(afterSaleOrderVo, afterSaleOrder);

        log.info("最后的状态机状态：{}", stateMachine.getState().getId());


        return afterSaleOrder;
    }

}
