package com.beppe.command.iml;

import com.beppe.command.Command;
import com.beppe.command.OrderCommandContext;
import com.beppe.model.Order;
import com.beppe.model.OrderHeader;
import org.springframework.stereotype.Component;

@Component("usePoint")
public class UsePoint implements Command {
    @Override
    public String getCmdKey() {
        return COMMAND_USE_POINT;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了UsePoint方法");
        Order order = commandContext.getOrder();
        OrderHeader orderHeader = order.getOrderHeader();
        orderHeader.setCustomerPhone("1569876");
    }
}
