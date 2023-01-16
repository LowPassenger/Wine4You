package com.sommelier.wine4you.model.dto.shoppingcart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sommelier.wine4you.model.OrderDetails;
import com.sommelier.wine4you.model.dto.item.ItemRequestDto;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CartRequestDto {
    private List<ItemRequestDto> itemRequestDtos;
    private Double deliveryPrice;
    private Integer discount;
    private BigDecimal totalAmount;
    private String email;
    private OrderDetails orderDetails;
}
