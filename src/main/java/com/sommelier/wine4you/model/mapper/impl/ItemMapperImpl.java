package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.Item;
import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.dto.item.ItemRequestDto;
import com.sommelier.wine4you.model.dto.item.ItemResponseDto;
import com.sommelier.wine4you.model.mapper.MapperToDto;
import com.sommelier.wine4you.model.mapper.MapperToModel;
import com.sommelier.wine4you.service.WineService;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements MapperToDto<ItemResponseDto, Item>,
        MapperToModel<Item, ItemRequestDto> {
    private final WineService wineService;

    public ItemMapperImpl(WineService wineService) {
        this.wineService = wineService;
    }

    @Override
    public ItemResponseDto toDto(Item item) {
        ItemResponseDto responseDto = new ItemResponseDto();
        responseDto.setId(item.getId());
        responseDto.setWineId(item.getWine().getId());
        responseDto.setWineQuantity(item.getQuantity());
        responseDto.setTotal(BigDecimal.valueOf(
                item.getWine().getPrice().doubleValue() * item.getQuantity()));
        return responseDto;
    }

    @Override
    public Item toModel(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        Wine wine = wineService.getById(itemRequestDto.getId());
        item.setWine(wine);
        item.setQuantity(itemRequestDto.getQuantity());
        item.setTotal(BigDecimal.valueOf(itemRequestDto.getQuantity()
                * wine.getPrice().doubleValue()));
        return item;
    }
}
