package com.beppe.fuse.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 5:38 下午
 */
public class CommandFactoryImpl implements CommandFactory {

    private final Map<String, Command> commandByKey = new HashMap<>();

    public CommandFactoryImpl(
            final List<Command> commandList) {

        for(Command command : commandList)
        {
            registerCommand(command);
        }
    }

    @Override
    public void execute(String key, CommandContext context) {

    }

    @Override
    public Future<Object> executeAsync(String key, CommandContext context) {
        return null;
    }

    @Override
    public void registerCommand(Command command) {

    }
}
