package com.beppe.kafka.service;

import com.beppe.kafka.entity.Order;

public interface OrderService {

    void createOrder(Order order);

    void cancelOrder(Order order);

    void shipment(Order order);

}
