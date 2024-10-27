package com.beppe.kafka.command.iml;

import com.beppe.kafka.command.Command;
import com.beppe.kafka.command.OrderCommandContext;
import com.beppe.kafka.model.Order;
import com.beppe.kafka.model.OrderDelivery;
import org.springframework.stereotype.Component;

@Component("validateWeight")
public class ValidateWeight implements Command {

    @Override
    public String getCmdKey() {
        return COMMAND_VALIDATE_WEIGHT;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了ValidateWeight方法");
        Order order = commandContext.getOrder();
        OrderDelivery orderDelivery = order.getOrderDelivery();
        orderDelivery.setReceiverName("大白");
    }
}
