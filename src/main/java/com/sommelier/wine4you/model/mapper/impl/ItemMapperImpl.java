package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.Item;
import com.sommelier.wine4you.model.dto.item.ItemRequestDto;
import com.sommelier.wine4you.model.dto.item.ItemResponseDto;
import com.sommelier.wine4you.model.mapper.MapperToDto;
import com.sommelier.wine4you.model.mapper.MapperToModel;
import com.sommelier.wine4you.service.OrderService;
import com.sommelier.wine4you.service.WineService;

public class ItemMapperImpl implements MapperToDto<ItemResponseDto, Item>,
        MapperToModel<Item, ItemRequestDto> {
    private final OrderService orderService;
    private final WineService wineService;

    public ItemMapperImpl(OrderService orderService, WineService wineService) {
        this.orderService = orderService;
        this.wineService = wineService;
    }

    @Override
    public ItemResponseDto toDto(Item item) {
        ItemResponseDto responseDto = new ItemResponseDto();
        responseDto.setId(item.getId());
        responseDto.setOrderId(item.getOrder().getId());
        responseDto.setWineId(item.getWine().getId());
        responseDto.setWineQuantity(item.getQuantity());
        responseDto.setTotal(item.getTotal());
        return responseDto;
    }

    @Override
    public Item toModel(ItemRequestDto itemRequestDto) {
        Item currentItem = new Item();
        currentItem.setOrder(orderService.g);
        currentItem.setWine(itemRequestDto.getWine());
        currentItem.setQuantity(itemRequestDto.getQuantity());
        currentItem.setTotal(itemRequestDto.getTotal());
        return currentItem;
    }
}
