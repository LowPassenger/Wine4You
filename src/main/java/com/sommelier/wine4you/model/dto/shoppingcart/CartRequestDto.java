package com.sommelier.wine4you.model.dto.shoppingcart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sommelier.wine4you.model.Address;
import com.sommelier.wine4you.model.dto.item.ItemRequestDto;
import com.sommelier.wine4you.model.enums.PaymentType;
import com.sommelier.wine4you.model.enums.ShippingType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private Address address;
    private Boolean dontCallMeBack;
    private Boolean buyAsGift;
    private ShippingType shipping;
    private PaymentType payment;
    private LocalDateTime createdDate;
}
