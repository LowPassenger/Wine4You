package com.sommelier.wine4you.model.dto;

import com.sommelier.wine4you.model.enums.Event;
import com.sommelier.wine4you.model.enums.WineStyle;
import com.sommelier.wine4you.model.enums.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class WineRequestDto {
    @NotBlank
    @Size(min = 2, message = "Wine brand should have at least 2 characters")
    private String brand;
    @NotEmpty
    private String country;
    @NotEmpty
    private Double price;
    private String title;
    private Boolean inStock;
    @NotEmpty
    private String name;
    @NotEmpty
    private WineStyle wineStyle;
    private WineTaste wineTaste;
    private Event event;
    @NotEmpty
    private WineType wineType;
    private double capasity;
    private String imageUrl;
    private String description;
}
