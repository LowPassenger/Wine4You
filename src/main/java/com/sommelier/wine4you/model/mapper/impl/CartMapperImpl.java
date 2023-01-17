package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.Address;
import com.sommelier.wine4you.model.Cart;
import com.sommelier.wine4you.model.dto.shoppingcart.CartRequestDto;
import com.sommelier.wine4you.model.dto.shoppingcart.CartResponseDto;
import com.sommelier.wine4you.model.mapper.MapperToDto;
import com.sommelier.wine4you.model.mapper.MapperToModel;
import com.sommelier.wine4you.service.AddressService;
import com.sommelier.wine4you.service.CartService;
import com.sommelier.wine4you.service.ItemService;
import com.sommelier.wine4you.service.UserService;
import com.sommelier.wine4you.service.WineService;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapperImpl implements MapperToModel<Cart, CartRequestDto>,
        MapperToDto<CartResponseDto, Cart> {
    private final ItemService itemService;
    private final CartService cartService;
    private final UserService userService;
    private final AddressService addressService;
    private final AddressMapperImpl addressMapper;
    private final WineService wineService;
    private final ItemMapperImpl itemMapper;

    @Autowired
    public CartMapperImpl(ItemService itemService,
                          CartService cartService,
                          UserService userService,
                          AddressService addressService,
                          AddressMapperImpl addressMapper,
                          WineService wineService,
                          ItemMapperImpl itemMapper) {
        this.itemService = itemService;
        this.cartService = cartService;
        this.userService = userService;
        this.addressService = addressService;
        this.addressMapper = addressMapper;
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
        cart.setAddress(addressService.create(
                addressMapper.toModel(cartRequestDto.getAddressRequestDto())));
        cart.setDontCallMeBack(cartRequestDto.getDontCallMeBack());
        cart.setBuyAsGift(cartRequestDto.getBuyAsGift());
        cart.setShipping(cartRequestDto.getShipping());
        cart.setPayment(cartRequestDto.getPayment());
        cart.setUser(userService.getByEmail(cartRequestDto.getEmail()));
        cart.setCreatedDate(LocalDateTime.now());
        return cart;
    }

    @Override
    public CartResponseDto toDto(Cart cart) {
        CartResponseDto responseDto = new CartResponseDto();
        responseDto.setId(cart.getId());
        responseDto.setItems(
                cart.getItems()
                        .stream()
                        .map(item -> itemMapper.toDto(item))
                        .toList()
        );
        responseDto.setUser(cart.getUser());
        responseDto.setDeliveryPrice(cart.getDeliveryPrice());
        responseDto.setDiscount(cart.getDiscount());
        responseDto.setTotalAmount(cart.getTotalAmount());
        responseDto.setAddressResponseDto(addressMapper.toDto(cart.getAddress()));
        responseDto.setDontCallMeBack(cart.getDontCallMeBack());
        responseDto.setBuyAsGift(cart.getBuyAsGift());
        responseDto.setShipping(cart.getShipping());
        responseDto.setPayment(cart.getPayment());
        responseDto.setCreatedDate(cart.getCreatedDate());
        return responseDto;
    }
}
