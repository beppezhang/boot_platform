package com.beppe.kafka.command.iml;

import com.beppe.kafka.command.Command;
import com.beppe.kafka.command.OrderCommandContext;
import com.beppe.kafka.model.Order;
import com.beppe.kafka.model.OrderDelivery;
import org.springframework.stereotype.Component;

@Component("validateDeliverTime")
public class ValidateDeliverTime implements Command {
    @Override
    public String getCmdKey() {
        return COMMAND_VALIDATE_DELIVER_TIME;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了ValidateDeliverTime方法");
        Order order = commandContext.getOrder();
        OrderDelivery orderDelivery = order.getOrderDelivery();
        orderDelivery.setGetReceiverPhone("888888");
    }
}
