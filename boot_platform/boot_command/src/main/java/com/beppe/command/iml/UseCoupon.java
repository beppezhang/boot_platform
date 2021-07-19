package com.beppe.command.iml;

import com.beppe.command.Command;
import com.beppe.command.OrderCommandContext;
import com.beppe.model.Order;
import com.beppe.model.OrderHeader;
import org.springframework.stereotype.Component;

@Component("useCoupon")
public class UseCoupon implements Command {
    @Override
    public String getCmdKey() {
        return COMMAND_USE_COUPON;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了UseCoupon方法");
        Order order = commandContext.getOrder();
        OrderHeader orderHeader = order.getOrderHeader();
        orderHeader.setOrderStatus("1");
    }
}
