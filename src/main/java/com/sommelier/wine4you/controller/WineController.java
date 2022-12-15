package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.dto.WineResponseDto;
import com.sommelier.wine4you.model.mapper.impl.WineMapperImpl;
import com.sommelier.wine4you.service.WineService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/wines")
public class WineController {
    private final WineService wineService;
    private final WineMapperImpl wineMapper;

    @Autowired
    public WineController(WineService wineService, WineMapperImpl wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
    }

    @GetMapping()
    public ResponseEntity<List<WineResponseDto>> getAllWines() {
        List<WineResponseDto> wineResponseDtos = wineService.getAll().stream()
                .map(wine -> wineMapper.toDto(wine))
                .collect(Collectors.toList());
        return ResponseEntity.ok(wineResponseDtos);
    }
}
