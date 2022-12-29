package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.dto.WineRequestDto;
import com.sommelier.wine4you.model.dto.WineResponseDto;
import com.sommelier.wine4you.model.mapper.MapperToDto;
import com.sommelier.wine4you.model.mapper.MapperToModel;
import com.sommelier.wine4you.service.EventService;
import com.sommelier.wine4you.service.WineStyleService;
import com.sommelier.wine4you.service.WineTasteService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WineMapperImpl implements MapperToDto<WineResponseDto, Wine>,
        MapperToModel<Wine, WineRequestDto> {
    private final WineStyleService wineStyleService;
    private final WineTasteService wineTasteService;
    private final EventService eventService;

    @Autowired
    public WineMapperImpl(WineStyleService wineStyleService,
                          WineTasteService wineTasteService,
                          EventService eventService) {
        this.wineStyleService = wineStyleService;
        this.wineTasteService = wineTasteService;
        this.eventService = eventService;
    }

    @Override
    public WineResponseDto toDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
        wineResponseDto.setBrand(wine.getBrand());
        wineResponseDto.setCountry(wine.getCountry());
        wineResponseDto.setPrice(wine.getPrice());
        wineResponseDto.setTitle(wine.getTitle());
        wineResponseDto.setInStock(wine.getInStock());
        wineResponseDto.setName(wine.getName());
        wineResponseDto.setWineStyle(wine.getWineStyle());
        wineResponseDto.setWineType(wine.getWineType());
        wineResponseDto.setWineTaste(wine.getWineTaste());
        wineResponseDto.setCapacity(wine.getCapacity());
        wineResponseDto.setEvent(wine.getEvent());
        wineResponseDto.setImageIds(wine.getImages()
                .stream()
                .map(image -> image.getId())
                .collect(Collectors.toList()));
        wineResponseDto.setDescription(wine.getDescription());
        return wineResponseDto;
    }

    @Override
    public Wine toModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        wine.setBrand(wineRequestDto.getBrand());
        wine.setCountry(wineRequestDto.getCountry());
        wine.setPrice(wineRequestDto.getPrice());
        wine.setTitle(wineRequestDto.getTitle());
        wine.setInStock(wineRequestDto.getInStock());
        wine.setName(wineRequestDto.getName());
        wine.setWineStyle(wineStyleService.getById(wineRequestDto.getWineStyleId()));
        wine.setWineType(wineRequestDto.getWineType());
        wine.setWineTaste(wineTasteService.getById(wineRequestDto.getWineTasteId()));
        wine.setCapacity(wineRequestDto.getCapacity());
        wine.setEvent(eventService.getById(wineRequestDto.getEventId()));
        wine.setDescription(wineRequestDto.getDescription());
        return wine;
    }
}
