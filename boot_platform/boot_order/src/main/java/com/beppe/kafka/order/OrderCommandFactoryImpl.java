package com.beppe.kafka.order;

import com.beppe.kafka.fuse.command.Command;
import com.beppe.kafka.fuse.command.CommandFactoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 5:37 下午
 */
@Slf4j
public class OrderCommandFactoryImpl extends CommandFactoryImpl implements OrderCommandFactory {


    private final Map<String, OrderCommand> commandByKey = new HashMap<>();

    public OrderCommandFactoryImpl(List<OrderCommand> commandList) {
        super(new ArrayList<Command>());
        for (OrderCommand command : commandList) {
            registerCommand(command);
        }
    }

    @Override
    public void execute(String key, OrderCommandContext context) {
        if (commandByKey.containsKey(key)) {
            OrderCommand command = commandByKey.get(key);
            command.execute(context);
        }
    }

    @Override
    public Future<Object> executeAsync(String key, OrderCommandContext context) {
        return null;
    }

    @Override
    public void registerCommand(OrderCommand orderCommand) {
        final Command command = commandByKey.get(orderCommand.getCmdKey());
        if (command != orderCommand) {
            if (command != null) {
                log.warn("Replacing order command impl for: {} with {}", orderCommand.getCmdKey(), command);
            } else {
                log.info("Adding order command impl for: {} with {}", orderCommand.getCmdKey(), command);
            }
        }
        commandByKey.put(orderCommand.getCmdKey(), orderCommand);
    }
}
