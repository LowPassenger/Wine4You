package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.ShoppingCart;
import com.sommelier.wine4you.model.User;

public interface ShoppingCartService {
    ShoppingCart getByUser(User user);

    ShoppingCart registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
