package com.beppe.fuse.command;

import java.util.concurrent.Future;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:41 下午
 */
public interface Command {

    String COMMAND_PERSIST_ORDER = "persist.order";

    void execute(CommandContext context);

    Future<Object> executeAsync(CommandContext context);

    String getCmdKey();
}
