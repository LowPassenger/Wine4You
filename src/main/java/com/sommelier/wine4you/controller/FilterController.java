package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.dto.EventResponseDto;
import com.sommelier.wine4you.model.mapper.impl.EventMapperImpl;
import com.sommelier.wine4you.model.mapper.impl.WineStyleMapperImpl;
import com.sommelier.wine4you.model.mapper.impl.WineTasteMapperImpl;
import com.sommelier.wine4you.service.EventService;
import com.sommelier.wine4you.service.WineStyleService;
import com.sommelier.wine4you.service.WineTasteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Rest API for filter conditions")
@RestController
@RequestMapping("api/v1/filters")
public class FilterController {
    private final EventService eventService;
    private final EventMapperImpl eventMapper;
    private final WineStyleService wineStyleService;
    private final WineStyleMapperImpl wineStyleMapper;
    private final WineTasteService wineTasteService;
    private final WineTasteMapperImpl wineTasteMapper;

    @Autowired
    public FilterController(EventService eventService,
                            EventMapperImpl eventMapper,
                            WineStyleService wineStyleService,
                            WineStyleMapperImpl wineStyleMapper,
                            WineTasteService wineTasteService,
                            WineTasteMapperImpl wineTasteMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
        this.wineStyleService = wineStyleService;
        this.wineStyleMapper = wineStyleMapper;
        this.wineTasteService = wineTasteService;
        this.wineTasteMapper = wineTasteMapper;
    }

    @ApiOperation(value = "Get Event by 'Id' Rest API")
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventMapper.toDto(eventService.getById(id)));
    }
}
