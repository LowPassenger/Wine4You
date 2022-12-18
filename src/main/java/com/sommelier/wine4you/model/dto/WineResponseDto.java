package com.sommelier.wine4you.model.dto;

import com.sommelier.wine4you.model.WineImage;
import com.sommelier.wine4you.model.enums.Event;
import com.sommelier.wine4you.model.enums.WineStyle;
import com.sommelier.wine4you.model.enums.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class WineResponseDto {
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
    private double capasity;
    private WineImage image;
    private String description;
}
