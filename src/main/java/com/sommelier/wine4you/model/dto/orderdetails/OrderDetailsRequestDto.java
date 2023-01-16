package com.sommelier.wine4you.model.dto.orderdetails;

import com.sommelier.wine4you.model.Address;
import com.sommelier.wine4you.model.dto.address.AddressRequestDto;
import com.sommelier.wine4you.model.enums.PaymentType;
import com.sommelier.wine4you.model.enums.ShippingType;
import lombok.Data;

@Data
public class OrderDetailsRequestDto {
    private Address deliveryAddress;
    private Boolean dontCallMeBack;
    private Boolean buyAsGift;
    private ShippingType shipping;
    private PaymentType payment;
}
