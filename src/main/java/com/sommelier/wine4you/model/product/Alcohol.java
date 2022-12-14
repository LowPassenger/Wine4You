package com.sommelier.wine4you.model.product;

import java.math.BigDecimal;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Alcohol extends Drink {
    protected byte alcoholPercent;

    public Alcohol(String country, String brand, BigDecimal price, boolean inStock,
                   float bottleSizeL, byte alcoholPercent) {
        super(country, brand, price, inStock, bottleSizeL);
        this.alcoholPercent = alcoholPercent;
    }
}