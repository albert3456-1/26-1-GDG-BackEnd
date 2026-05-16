package com.example.shop.order.repository;

import com.example.shop.order.Order;

import java.util.List;

public interface OrderRepository {
    Order findById(Long id);
    List<Order> findAll();
    Order findByOrderId(String orderId);
    void save(Order order);
    void deleteById(Long id);
}
