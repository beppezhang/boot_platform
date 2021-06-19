package com.beppe.impl;

import com.beppe.model.OrderEntity;
import com.beppe.fuse.OrderEvent;
import com.beppe.fuse.command.Command;
import com.beppe.order.OrderCommandContext;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mon co
 * @description
 * @time 2021/5/6 8:07 下午
 */
@Data
public class OrderEventImpl implements OrderEvent {

    private String orderId;
    private OrderEntity customerOrderEntity;
    private Map<String, Object> parameters = new HashMap<>();
    private OrderCommandContext orderCommandContext = null;
    private boolean transactionTrackingRequired;


    private final String eventId;
    private final String operatorId;
    private final String operatorName;

    //By default, the transaction tracking is true.
    public OrderEventImpl(final String operatorId,
                          final String eventId,
                          final OrderEntity customerOrderEntity) {
        this(operatorId, null, eventId, customerOrderEntity, null, true);
    }

    public OrderEventImpl(final String operatorId,
                          final OrderEventImpl parent,
                          final String eventId,
                          final OrderEntity customerOrderEntity,
                          final Map params,
                          final boolean transactionTrakcingRequired) {
        this.eventId = eventId;
        this.operatorId = operatorId;
        this.operatorName = operatorId; //TODO : figure out the operator Name;
        this.customerOrderEntity = customerOrderEntity;
        this.parameters = params == null ? new HashMap<>() : params;
        this.transactionTrackingRequired = transactionTrakcingRequired;
        if (customerOrderEntity != null)
            this.setOrderId(customerOrderEntity.getOrderId());
    }

    private void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    @Override
    public boolean handle(OrderEvent orderEvent) {
        return false;
    }

    @Override
    public String getEventId() {
        return eventId;
    }

    @Override
    public OrderCommandContext getOrderCommandContext() {
        if (orderCommandContext == null) {
            orderCommandContext = new OrderCommandContext();
            orderCommandContext.setOrderEntity(getCustomerOrderEntity());
            orderCommandContext.setOrderEvent(this);
            orderCommandContext.setParameter(Command.COMMAND_PERSIST_ORDER, getOperatorId());
            orderCommandContext.setTransactionTrackingRequired(this.transactionTrackingRequired);
        }
        return orderCommandContext;
    }

    @Override
    public void setParameter(String eventKey, Object obj) {
        parameters.put(eventKey, obj);
    }

    @Override
    public Object getParameter(String eventKey) {
        return parameters.get(eventKey);
    }
}
