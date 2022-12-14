package com.sommelier.wine4you.model.product;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {
    protected String country;
    protected String brand;
    protected BigDecimal price;
    protected boolean inStock;
}
