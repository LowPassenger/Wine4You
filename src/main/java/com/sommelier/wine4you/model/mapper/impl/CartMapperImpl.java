package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.Cart;
import com.sommelier.wine4you.model.dto.shoppingcart.CartRequestDto;
import com.sommelier.wine4you.model.mapper.MapperToModel;
import com.sommelier.wine4you.service.AddressService;
import com.sommelier.wine4you.service.CartService;
import com.sommelier.wine4you.service.ItemService;
import com.sommelier.wine4you.service.OrderDetailsService;
import com.sommelier.wine4you.service.UserService;
import com.sommelier.wine4you.service.WineService;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapperImpl implements MapperToModel<Cart, CartRequestDto> {
    private final ItemService itemService;
    private final CartService cartService;
    private final UserService userService;
    private final AddressService addressService;
    private final AddressMapperImpl addressMapper;
    private final WineService wineService;
    private final ItemMapperImpl itemMapper;
    private final OrderDetailsService orderDetailsService;

    @Autowired
    public CartMapperImpl(ItemService itemService,
                          CartService cartService,
                          UserService userService,
                          AddressService addressService,
                          AddressMapperImpl addressMapper,
                          WineService wineService,
                          ItemMapperImpl itemMapper,
                          OrderDetailsService orderDetailsService) {
        this.itemService = itemService;
        this.cartService = cartService;
        this.userService = userService;
        this.addressService = addressService;
        this.addressMapper = addressMapper;
        this.wineService = wineService;
        this.itemMapper = itemMapper;
        this.orderDetailsService = orderDetailsService;
    }

    @Override
    public Cart toModel(CartRequestDto cartRequestDto) {
        Cart cart = new Cart();
        cart.setItems(
                cartRequestDto.getItemRequestDtos()
                        .stream()
                        .map(p -> itemService.create(itemMapper.toModel(p)))
                        .collect(Collectors.toList())
        );
        cart.setDeliveryPrice(cartRequestDto.getDeliveryPrice());
        cart.setDiscount(cartRequestDto.getDiscount());
        cart.setTotalAmount(cartRequestDto.getTotalAmount());
        cart.setOrderDetails(cartRequestDto.getOrderDetails());
        cart.setUser(userService.getByEmail(cartRequestDto.getEmail()));
        cart.setCreatedDate(LocalDateTime.now());
        return cart;
    }
}
