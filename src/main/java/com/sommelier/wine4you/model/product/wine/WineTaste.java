package com.sommelier.wine4you.model.product.wine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WineTaste {
    TROPICAL("Tropical"),
    BLACKBERRY("Blackberry"),
    CHOCOLATE("Chocolate"),
    VANILLA("Vanilla");

    private final String taste;
}
