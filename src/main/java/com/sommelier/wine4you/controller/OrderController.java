package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.Order;
import com.sommelier.wine4you.model.User;
import com.sommelier.wine4you.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
//    private final OrderService orderService;
//
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Order>> getAll() {
//        return ResponseEntity.ok(orderService.getAll());
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Order>> getAllByUser(User user) {
//
//        return ResponseEntity.ok(orderService.getOrdersHistory(user));
//    }
}
