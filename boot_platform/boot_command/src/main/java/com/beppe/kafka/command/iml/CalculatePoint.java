package com.beppe.kafka.command.iml;

import com.beppe.kafka.command.Command;
import com.beppe.kafka.command.OrderCommandContext;
import com.beppe.kafka.model.Order;
import com.beppe.kafka.model.OrderHeader;
import org.springframework.stereotype.Component;

@Component("calculatePoint")
public class CalculatePoint implements Command {

    @Override
    public String getCmdKey() {
        return COMMAND_CALCULATE_POINT;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了CalculatePoint方法");
        Order order = commandContext.getOrder();
        OrderHeader orderHeader = order.getOrderHeader();
        orderHeader.setName("beppe");

    }
}
