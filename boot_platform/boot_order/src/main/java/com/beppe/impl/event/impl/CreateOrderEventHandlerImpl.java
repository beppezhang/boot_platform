package com.beppe.impl.event.impl;

import com.beppe.fuse.OrderEvent;
import com.beppe.fuse.OrderEventHandler;
import com.beppe.fuse.command.CommandTransactionScope;
import com.beppe.fuse.command.CommandTransactionScopeImpl;
import com.beppe.order.OrderCommandContext;
import com.beppe.handler.AbstractOrderEventHandlerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 3:36 下午
 */
@Slf4j
@Component("createOrderEventHandler") // 配置的 createOrderEventHandler 名称和 配置文件中的相同 类似于 spring框架中的 SPI 配置
public class CreateOrderEventHandlerImpl extends AbstractOrderEventHandlerImpl implements OrderEventHandler {


    @Override
    protected boolean handleInternal(final OrderEvent orderEvent) {
        OrderCommandContext context = orderEvent.getOrderCommandContext();
        orderCommandFactory.execute("persist.order", context);
        Future<Object> riskFuture = orderCommandFactory.executeAsync("命令Code", context);
        // 阻塞拿数据
        try {
            riskFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        CommandTransactionScope transactionScope = new CommandTransactionScopeImpl(orderCommandFactory){
            @Override
            public void executeWithRollback() {
                // 执行特定业务的分布式事务回滚
                log.info("分布式事务回滚操作");
            }
        };
        transactionScope.executeWithRollback();
        return false;
    }

}
