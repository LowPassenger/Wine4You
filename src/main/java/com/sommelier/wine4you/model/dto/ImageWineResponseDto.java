package com.sommelier.wine4you.model.dto;

import lombok.Data;

@Data
public class ImageWineResponseDto {
    private Long id;
    private String name;
    private String type;
    private String urlPath;
}
