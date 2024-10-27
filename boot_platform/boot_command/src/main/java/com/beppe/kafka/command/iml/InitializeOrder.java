package com.beppe.kafka.command.iml;

import com.beppe.kafka.command.Command;
import com.beppe.kafka.command.OrderCommandContext;
import com.beppe.kafka.model.Order;
import com.beppe.kafka.model.OrderHeader;
import org.springframework.stereotype.Component;

@Component("initializeOrder")
public class InitializeOrder implements Command {
    @Override
    public String getCmdKey() {
        return COMMAND_INITIALIZE_ORDER;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了InitializeOrder方法");
        Order order = commandContext.getOrder();
        OrderHeader orderHeader = order.getOrderHeader();
        orderHeader.setOrderAt("2021-07-09");
    }
}
