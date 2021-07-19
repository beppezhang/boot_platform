package com.beppe.command;

import com.beppe.model.Order;

import java.util.Map;

/**
 * 命令行执行过程中  入参和执行结果上下文
 */
public class OrderCommandContext {

    private Order order =new Order();

    private Map<String, String> pram;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Map<String, String> getPram() {
        return pram;
    }

    public void setPram(Map<String, String> pram) {
        this.pram = pram;
    }
}
