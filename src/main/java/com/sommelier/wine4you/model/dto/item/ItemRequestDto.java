package com.sommelier.wine4you.model.dto.item;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ItemRequestDto {
    @NotEmpty
    private Long orderId;
    @NotEmpty
    private Long wineId;
    @Min(1)
    private Integer wineQuantity;
    private BigDecimal total;
}
