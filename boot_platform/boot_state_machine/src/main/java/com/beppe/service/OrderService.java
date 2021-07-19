package com.beppe.service;

import com.beppe.entity.Order;

public interface OrderService {

    void createOrder(Order order);

    void cancelOrder(Order order);

    void shipment(Order order);

}
