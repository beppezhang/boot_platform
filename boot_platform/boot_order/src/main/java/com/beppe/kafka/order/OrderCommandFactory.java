package com.beppe.kafka.order;

import com.beppe.kafka.fuse.command.CommandFactory;

import java.util.concurrent.Future;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:56 下午
 */
public interface OrderCommandFactory extends CommandFactory {

    void execute(String key, OrderCommandContext context);

    Future<Object> executeAsync(String key, OrderCommandContext context);

    void registerCommand( OrderCommand command);

}
