package com.beppe.handler;

import com.beppe.fuse.OrderEvent;
import com.beppe.fuse.OrderEventHandler;
import com.beppe.order.OrderCommandFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:24 下午
 */
public abstract class AbstractOrderEventHandlerImpl implements OrderEventHandler {


    @Autowired
    protected OrderCommandFactory orderCommandFactory;

    protected abstract boolean handleInternal(OrderEvent orderEvent);

    @Override
    public boolean handle(OrderEvent orderEvent) {
        return handleWrap(orderEvent);
    }


    private boolean handleWrap(OrderEvent orderEvent) {
        boolean result;
        result = handleInternal(orderEvent);
        return result;
    }
}
