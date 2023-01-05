package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.Order;
import com.sommelier.wine4you.model.ShoppingCart;
import com.sommelier.wine4you.model.User;
import java.util.List;

public interface OrderService extends GenericService<Order> {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
