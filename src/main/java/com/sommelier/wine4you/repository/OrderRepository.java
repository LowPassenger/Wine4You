package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.Order;
import com.sommelier.wine4you.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUser(User user);
}
