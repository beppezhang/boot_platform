package com.beppe.kafka.order;

import com.beppe.kafka.fuse.command.Command;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:57 下午
 */
public interface OrderCommand extends Command {


    void execute(OrderCommandContext context);

}
