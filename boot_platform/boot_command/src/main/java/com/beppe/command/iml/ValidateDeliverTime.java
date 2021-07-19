package com.beppe.command.iml;

import com.beppe.command.Command;
import com.beppe.command.OrderCommandContext;
import com.beppe.model.Order;
import com.beppe.model.OrderDelivery;
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
