package com.sommelier.wine4you.model.product;

import com.sommelier.wine4you.model.product.wine.Price;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Alcohol extends Drink {
    protected float alcoholPercent;

    public Alcohol(String country, String brand, Price price, boolean inStock,
                   float bottleSizeL, float alcoholPercent) {
        super(country, brand, price, inStock, bottleSizeL);
        this.alcoholPercent = alcoholPercent;
    }
}
