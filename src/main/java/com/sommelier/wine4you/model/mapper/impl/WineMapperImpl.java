package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.dto.WineRequestDto;
import com.sommelier.wine4you.model.dto.WineResponseDto;
import com.sommelier.wine4you.model.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class WineMapperImpl implements GenericMapper<WineResponseDto, Wine, WineRequestDto> {
    @Override
    public WineResponseDto toDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setBrand(wine.getBrand());
        wineResponseDto.setCountry(wine.getCountry());
        wineResponseDto.setPrice(wine.getPrice());
        wineResponseDto.setTitle(wine.getTitle());
        wineResponseDto.setInStock(wine.getInStock());
        wineResponseDto.setName(wine.getName());
        wineResponseDto.setWineStyle(wine.getWineStyle());
        wineResponseDto.setWineType(wine.getWineType());
        wineResponseDto.setWineTaste(wine.getWineTaste());
        wineResponseDto.setCapasity(wine.getCapasity());
        wineResponseDto.setEvent(wine.getEvent());
        wineResponseDto.setImageUrl(wine.getImageUrl());
        wineResponseDto.setDescription(wine.getDescription());
        return wineResponseDto;
    }

    @Override
    public Wine toModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        return wine;
    }
}
