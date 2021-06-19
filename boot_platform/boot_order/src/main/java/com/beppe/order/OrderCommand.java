package com.beppe.order;

import com.beppe.fuse.command.Command;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:57 下午
 */
public interface OrderCommand extends Command {


    void execute(OrderCommandContext context);

}
