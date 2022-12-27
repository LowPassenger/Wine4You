package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.Event;
import com.sommelier.wine4you.model.WineStyle;
import com.sommelier.wine4you.model.dto.EventResponseDto;
import com.sommelier.wine4you.model.dto.WineRequestCriteriaDto;
import com.sommelier.wine4you.model.dto.WineResponseDto;
import com.sommelier.wine4you.model.enums.WineType;
import com.sommelier.wine4you.model.mapper.impl.EventMapperImpl;
import com.sommelier.wine4you.model.mapper.impl.WineMapperImpl;
import com.sommelier.wine4you.model.mapper.impl.WineStyleMapperImpl;
import com.sommelier.wine4you.model.mapper.impl.WineTasteMapperImpl;
import com.sommelier.wine4you.service.EventService;
import com.sommelier.wine4you.service.WineService;
import com.sommelier.wine4you.service.WineStyleService;
import com.sommelier.wine4you.service.WineTasteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    private final WineMapperImpl wineMapper;
    private final WineService wineService;

    @Autowired
    public FilterController(EventService eventService,
                            EventMapperImpl eventMapper,
                            WineStyleService wineStyleService,
                            WineStyleMapperImpl wineStyleMapper,
                            WineTasteService wineTasteService,
                            WineTasteMapperImpl wineTasteMapper,
                            WineMapperImpl wineMapper,
                            WineService wineService) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
        this.wineStyleService = wineStyleService;
        this.wineStyleMapper = wineStyleMapper;
        this.wineTasteService = wineTasteService;
        this.wineTasteMapper = wineTasteMapper;
        this.wineMapper = wineMapper;
        this.wineService = wineService;
    }

    @ApiOperation(value = "Get Event by 'Id' Rest API")
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventMapper.toDto(eventService.getById(id)));
    }

    @GetMapping()
    public ResponseEntity<List<WineResponseDto>> getWinesCriteria(
            @RequestBody WineRequestCriteriaDto criteriaDto) {

        WineType wineType = WineType.valueOf(criteriaDto.getWineType());
        WineStyle wineStyle = wineStyleService.getdByStyleName(criteriaDto.getWineStyle());
        Event event = eventService.findByEventName(criteriaDto.getEvent());

        return ResponseEntity.ok(wineService.getByWinesAllFilters(wineType, wineStyle, event,
                criteriaDto.getBrand(),
                criteriaDto.getCountry(),
                criteriaDto.getMin(),
                criteriaDto.getMax()
        ).stream().map(wineMapper::toDto).collect(Collectors.toList()));

    }
}
