package com.sommelier.wine4you.model.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ItemRequestDto {
    @NotEmpty
    private Long id;
    @Min(1)
    private Integer quantity;
}
