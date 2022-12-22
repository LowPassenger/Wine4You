package com.sommelier.wine4you.model.product;

import com.sommelier.wine4you.model.product.wine.Price;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {
    protected String country;
    protected String brand;
    protected Price price;
    protected boolean inStock;
}
