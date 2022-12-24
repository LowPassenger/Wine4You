package com.sommelier.wine4you.model.dto;

import com.sommelier.wine4you.model.Event;
import com.sommelier.wine4you.model.WineImage;
import com.sommelier.wine4you.model.WineStyle;
import com.sommelier.wine4you.model.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String brand;
    private String country;
    private BigDecimal price;
    private String title;
    private Boolean inStock;
    private String name;
    private WineStyle wineStyle;
    private WineType wineType;
    private WineTaste wineTaste;
    private Event event;
    private double capacity;
    private WineImage image;
    private String description;
}
