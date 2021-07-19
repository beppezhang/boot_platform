package com.beppe.command.iml;

import com.beppe.command.Command;
import com.beppe.command.OrderCommandContext;
import com.beppe.model.Order;
import com.beppe.model.OrderHeader;
import org.springframework.stereotype.Component;

@Component("setOrderId")
public class SetOrderId implements Command {
    @Override
    public String getCmdKey() {
        return COMMAND_SET_ORDER_ID;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了SetOrderId方法");
        Order order = commandContext.getOrder();
        OrderHeader orderHeader = order.getOrderHeader();
        orderHeader.setId(198303l);
    }
}
