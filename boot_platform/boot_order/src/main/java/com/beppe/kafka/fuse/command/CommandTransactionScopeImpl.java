package com.beppe.kafka.fuse.command;

import com.beppe.kafka.order.OrderCommandFactory;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 5:51 下午
 */
public class CommandTransactionScopeImpl implements CommandTransactionScope{

    private OrderCommandFactory orderCommandFactory;

    public CommandTransactionScopeImpl(OrderCommandFactory orderCommandFactory){
        this.orderCommandFactory = orderCommandFactory;
    }

    @Override
    public void executeWithRollback() {

    }
}
