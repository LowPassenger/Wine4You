package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.Cart;
import com.sommelier.wine4you.model.dto.shoppingcart.CartRequestDto;
import com.sommelier.wine4you.model.mapper.impl.CartMapperImpl;
import com.sommelier.wine4you.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carts")
public class CartController {
    private final CartService cartService;
    private final CartMapperImpl cartMapper;

    @Autowired
    public CartController(CartService cartService,
                          CartMapperImpl cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody CartRequestDto cartRequestDto) {
        return new ResponseEntity<>(cartService.addItemsToCart(
                cartMapper.toModel(cartRequestDto)), HttpStatus.CREATED);
    }
}
