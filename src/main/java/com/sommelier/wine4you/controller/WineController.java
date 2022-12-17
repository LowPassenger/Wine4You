package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.dto.WineResponseDto;
import com.sommelier.wine4you.model.mapper.impl.WineMapperImpl;
import com.sommelier.wine4you.service.WineService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/brand")
    public ResponseEntity<List<WineResponseDto>> getAllWinesByBrand(
            @RequestParam(value = "brand") String brand) {
        List<WineResponseDto> wineResponseDtos
                = wineService.getAllByBrand(brand).stream()
                .map(wine -> wineMapper.toDto(wine))
                .collect(Collectors.toList());
        return ResponseEntity.ok(wineResponseDtos);
    }

    @GetMapping("/nameWine")
    public ResponseEntity<List<WineResponseDto>> getAllWinesByNameWine(
            @RequestParam(value = "nameWine") String nameWine) {
        List<WineResponseDto> wineResponseDtos
                = wineService.getAllByName(nameWine).stream()
                .map(wine -> wineMapper.toDto(wine))
                .collect(Collectors.toList());
        return ResponseEntity.ok(wineResponseDtos);
    }

    @GetMapping("/between-price")
    public ResponseEntity<List<WineResponseDto>> getAllWinesByPrice(
            @RequestParam(value = "min") BigDecimal min,
            @RequestParam(value = "max") BigDecimal max) {
        return ResponseEntity.ok(wineService.getWinesByPriceBetween(min, max).stream()
                .map(wine -> wineMapper.toDto(wine))
                .collect(Collectors.toList()));
    }
}
