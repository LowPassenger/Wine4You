package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.OrderDetails;
import com.sommelier.wine4you.model.dto.orderdetails.OrderDetailsRequestDto;
import com.sommelier.wine4you.model.dto.orderdetails.OrderDetailsResponseDto;
import com.sommelier.wine4you.model.mapper.MapperToDto;
import com.sommelier.wine4you.model.mapper.MapperToModel;
import com.sommelier.wine4you.service.OrderDetailsService;

public class OrderDetailsMapperImpl implements MapperToDto<OrderDetailsResponseDto, OrderDetails>,
        MapperToModel<OrderDetails, OrderDetailsRequestDto> {
    private final OrderDetailsService orderDetailsService;

    public OrderDetailsMapperImpl(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }


    @Override
    public OrderDetailsResponseDto toDto(OrderDetails orderDetails) {
        OrderDetailsResponseDto responseDto = new OrderDetailsResponseDto();
        responseDto.setId(orderDetails.getId());
        responseDto.setDeliveryAddress(orderDetails.getDeliveryAddress());
        responseDto.setShipping(orderDetails.getShipping());
        responseDto.setPayment(orderDetails.getPayment());
        responseDto.setDontCallMeBack(orderDetails.getDontCallMeBack());
        responseDto.setBuyAsGift(orderDetails.getBuyAsGift());
        return null;
    }

    @Override
    public OrderDetails toModel(OrderDetailsRequestDto orderDetailsRequestDto) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setDeliveryAddress(orderDetailsRequestDto.getDeliveryAddress());
        orderDetails.setPayment(orderDetailsRequestDto.getPayment());
        orderDetails.setShipping(orderDetailsRequestDto.getShipping());
        orderDetails.setBuyAsGift(orderDetailsRequestDto.getBuyAsGift());
        orderDetails.setDontCallMeBack(orderDetailsRequestDto.getDontCallMeBack());
        return orderDetails;
    }
}
