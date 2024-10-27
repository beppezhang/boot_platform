package com.beppe.kafka.command.iml;

import com.beppe.kafka.command.Command;
import com.beppe.kafka.command.OrderCommandContext;
import com.beppe.kafka.model.Order;
import com.beppe.kafka.model.OrderDelivery;
import org.springframework.stereotype.Component;

@Component("validateBalance")
public class ValidateBalance implements Command {
    @Override
    public String getCmdKey() {
        return COMMAND_VALIDATE_BALANCE;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了ValidateBalance方法");
        Order order = commandContext.getOrder();
        OrderDelivery orderDelivery = order.getOrderDelivery();
        orderDelivery.setCustomerAddr("shanghai");
    }
}
