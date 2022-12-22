package com.sommelier.wine4you.model.product;

import com.sommelier.wine4you.model.product.wine.Price;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Drink extends Product {
    protected float bottleSizeL;

    public Drink(String country, String brand, Price price, boolean inStock,
                 float bottleSizeL) {
        super(country, brand, price, inStock);
        this.bottleSizeL = bottleSizeL;
    }
}
