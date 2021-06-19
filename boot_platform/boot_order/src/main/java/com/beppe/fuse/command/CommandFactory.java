package com.beppe.fuse.command;

import java.util.concurrent.Future;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:54 下午
 */
public interface CommandFactory {

    void execute(String key, CommandContext context);

    Future<Object> executeAsync(final String key, final CommandContext context);

    void registerCommand(Command command);
}
