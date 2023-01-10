package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.Cart;
import com.sommelier.wine4you.model.dto.shoppingcart.CartRequestDto;
import com.sommelier.wine4you.model.mapper.MapperToModel;
import com.sommelier.wine4you.service.CartService;
import com.sommelier.wine4you.service.ItemService;
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
    private final WineService wineService;
    private final ItemMapperImpl itemMapper;

    @Autowired
    public CartMapperImpl(ItemService itemService,
                          CartService cartService,
                          UserService userService,
                          WineService wineService,
                          ItemMapperImpl itemMapper) {
        this.itemService = itemService;
        this.cartService = cartService;
        this.userService = userService;
        this.wineService = wineService;
        this.itemMapper = itemMapper;
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
        cart.setAddress(cartRequestDto.getAddress());
        cart.setDontCallMeBack(cartRequestDto.getDontCallMeBack());
        cart.setBuyAsGift(cartRequestDto.getBuyAsGift());
        cart.setShipping(cartRequestDto.getShipping());
        cart.setPayment(cartRequestDto.getPayment());
        cart.setUser(userService.getByEmail(cartRequestDto.getEmail()));
        cart.setCreatedDate(LocalDateTime.now());
        return cart;
    }
}
