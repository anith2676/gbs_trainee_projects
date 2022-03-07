package com.gbs.orderprocessing.Services;

import java.util.Optional;

import com.gbs.orderprocessing.Model.Order;
import com.gbs.orderprocessing.OrderRepository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order create(Order order) {

        return orderRepository.save(order);
    }

    @Override
    public Order save(Order entity) {

        return orderRepository.save(entity);
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {

        return orderRepository.findById(id);
    }

}
