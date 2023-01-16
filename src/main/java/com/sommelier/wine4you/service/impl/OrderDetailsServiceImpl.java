package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.exception.ResourceNotFoundException;
import com.sommelier.wine4you.model.OrderDetails;
import com.sommelier.wine4you.repository.OrderDetailsRepository;
import com.sommelier.wine4you.service.OrderDetailsService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public OrderDetails create(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails getById(Long id) {
        return orderDetailsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("OrderDetails", "id", String.valueOf(id))
        );
    }

    @Override
    public List<OrderDetails> getAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        orderDetailsRepository.deleteById(id);
        return orderDetailsRepository.existsById(id);
    }

    @Override
    public OrderDetails update(Long id, OrderDetails orderDetails) {
        orderDetails.setId(id);
        return orderDetailsRepository.save(orderDetails);
    }
}
