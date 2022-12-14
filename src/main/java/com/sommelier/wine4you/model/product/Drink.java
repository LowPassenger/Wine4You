package com.sommelier.wine4you.model.product;

import java.math.BigDecimal;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Drink extends Product {
    protected float bottleSizeL;

    public Drink(String country, String brand, BigDecimal price, boolean inStock,
                 float bottleSizeL) {
        super(country, brand, price, inStock);
        this.bottleSizeL = bottleSizeL;
    }
}
