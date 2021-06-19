package com.beppe.order;

import com.beppe.model.OrderEntity;
import com.beppe.fuse.OrderEvent;
import com.beppe.fuse.command.CommandContext;
import org.javatuples.Pair;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mon co
 * @description 订单命令上下文
 * @time 2021/4/30 3:57 下午
 */
public class OrderCommandContext extends CommandContext implements Serializable {

    private static final long serialVersionUID = -8307838037208666988L;

    /**
     * 整个订单信息
     */
    private OrderEntity orderEntity;

    /**
     * 订单事件
     */
    private OrderEvent orderEvent;

    /**
     * 回滚
     */
    private final Map<String, Pair<String, OrderCommandContext>> rollbackMap = new HashMap<>();

    private boolean transactionTrackingRequired;

    public OrderCommandContext() {
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public OrderEvent getOrderEvent() {
        return orderEvent;
    }

    public void setOrderEvent(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }

    public boolean isTransactionTrackingRequired() {
        return transactionTrackingRequired;
    }

    public void setTransactionTrackingRequired(boolean transactionTrackingRequired) {
        this.transactionTrackingRequired = transactionTrackingRequired;
    }

    public Map<String, Pair<String, OrderCommandContext>> getRollbackMap() {
        return rollbackMap;
    }
}
