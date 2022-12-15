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
        wineResponseDto.setName(wine.getName());
        wineResponseDto.setPrice(wine.getPrice());
        return wineResponseDto;
    }

    @Override
    public Wine toModel(WineRequestDto wineRequestDto) {
        return null;
    }
}
