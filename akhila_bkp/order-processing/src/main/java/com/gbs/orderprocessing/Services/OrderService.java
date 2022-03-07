package com.gbs.orderprocessing.Services;

import java.util.Optional;

import com.gbs.orderprocessing.Model.Order;

public interface OrderService {

    Order create(Order order);

    Optional<Order> getOrderById(Integer id);

    Order save(Order entity);

}
