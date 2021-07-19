package com.beppe.command.iml;

import com.beppe.command.Command;
import com.beppe.command.OrderCommandContext;
import com.beppe.model.Order;
import com.beppe.model.OrderDelivery;
import com.beppe.model.OrderHeader;
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
