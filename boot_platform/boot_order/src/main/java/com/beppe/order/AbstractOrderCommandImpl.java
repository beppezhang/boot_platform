package com.beppe.order;

import com.beppe.fuse.command.CommandContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.Future;

/**
 * @author Mon co
 * @description
 * @time 2021/5/6 9:03 下午
 */
public class AbstractOrderCommandImpl implements OrderCommand, ApplicationContextAware {


    @Override
    public void execute(CommandContext context) {
        throw new IndexOutOfBoundsException("OrderCommandContext execute not implemented");

    }

    @Override
    public Future<Object> executeAsync(CommandContext context) {
        return null;
    }

    @Override
    public String getCmdKey() {
        return null;
    }


    @Override
    public void execute(OrderCommandContext context) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
