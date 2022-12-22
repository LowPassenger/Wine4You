package com.sommelier.wine4you.model.product;

import com.sommelier.wine4you.model.product.wine.Price;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Food extends Product {
    protected short netWeightG;

    public Food(String country, String brand, Price price, boolean inStock,
                short netWeightG) {
        super(country, brand, price, inStock);
        this.netWeightG = netWeightG;
    }
}
