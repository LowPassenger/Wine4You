package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.dto.WineResponseDto;
import com.sommelier.wine4you.model.mapper.impl.WineMapperImpl;
import com.sommelier.wine4you.service.WineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Rest API for product promotion")
@RestController
@RequestMapping("api/v1/promotions")
public class PromotionController {
    private static final Long PROMOTION_PRODUCTS_QUANTITY = 4L;
    private final WineService wineService;
    private final WineMapperImpl wineMapper;

    public PromotionController(WineService wineService, WineMapperImpl wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
    }

    @ApiOperation(value = "Get wine promotion of the week REST API")
    @GetMapping("/wines")
    public List<ResponseEntity<WineResponseDto>> getWinePromotion() {
        List<ResponseEntity<WineResponseDto>> promotions = new ArrayList<>();
        for (Long i = 1L; i < PROMOTION_PRODUCTS_QUANTITY; i++) {
            promotions.add(ResponseEntity
                    .ok(wineMapper.toDto(wineService.getById(i))));
        }
        return promotions;
    }

    @ApiOperation(value = "Get champagne promotion of the week REST API")
    @GetMapping("/champagnes")
    public List<ResponseEntity<WineResponseDto>> getChampagnePromotion() {
        List<ResponseEntity<WineResponseDto>> promotions = new ArrayList<>();
        for (Long i = 5L; i < PROMOTION_PRODUCTS_QUANTITY; i++) {
            promotions.add(ResponseEntity
                    .ok(wineMapper.toDto(wineService.getById(i))));
        }
        return promotions;
    }
}
