package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.exception.ResourceNotFoundException;
import com.sommelier.wine4you.model.Order;
import com.sommelier.wine4you.model.ShoppingCart;
import com.sommelier.wine4you.model.User;
import com.sommelier.wine4you.repository.OrderRepository;
import com.sommelier.wine4you.service.OrderService;
import com.sommelier.wine4you.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setCreatedDate(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        orderRepository.save(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderRepository.findOrdersByUser(user).orElseThrow(
                () -> new ResourceNotFoundException("Order", "User", user.toString())
        );
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order", "Id", String.valueOf(id))
        );
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order update(Long id, Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }
}
