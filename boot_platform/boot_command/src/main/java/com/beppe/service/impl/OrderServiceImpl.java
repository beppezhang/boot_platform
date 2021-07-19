package com.beppe.service.impl;

import com.beppe.command.Command;
import com.beppe.command.OrderCommandContext;
import com.beppe.command.OrderCommandFactory;
import com.beppe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderCommandFactory orderCommandFactory;

    @Override
    public void confirmOrder() {
        // 开始执行下单的流程   执行对应的命令行
        OrderCommandContext orderCommandContext = new OrderCommandContext();
        orderCommandFactory.execute(Command.COMMAND_CALCULATE_POINT, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_CALCULATE_PROMOTION, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_INITIALIZE_ORDER, orderCommandContext);
        System.out.println("正在下单中");
        orderCommandFactory.execute(Command.COMMAND_SET_ORDER_ID, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_USE_COUPON, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_USE_POINT, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_VALIDATE_BALANCE, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_VALIDATE_COUPON, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_VALIDATE_DELIVER_TIME, orderCommandContext);
        orderCommandFactory.execute(Command.COMMAND_VALIDATE_WEIGHT, orderCommandContext);
    }
}
