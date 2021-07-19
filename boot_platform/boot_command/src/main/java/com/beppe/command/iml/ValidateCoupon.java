package com.beppe.command.iml;

import com.beppe.command.Command;
import com.beppe.command.OrderCommandContext;
import com.beppe.model.Order;
import com.beppe.model.OrderDelivery;
import org.springframework.stereotype.Component;

@Component("validateCoupon")
public class ValidateCoupon implements Command {
    @Override
    public String getCmdKey() {
        return COMMAND_VALIDATE_COUPON;
    }

    @Override
    public void execute(OrderCommandContext commandContext) {
        System.out.println("执行了ValidateCoupon方法");
        Order order = commandContext.getOrder();
        OrderDelivery orderDelivery = order.getOrderDelivery();
        orderDelivery.setDelType("001");
    }
}
