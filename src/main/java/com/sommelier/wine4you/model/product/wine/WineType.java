package com.sommelier.wine4you.model.product.wine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WineType {
    WHITE("White wine"),
    RED("Red wine"),
    CHAMPAGNE_SPARKLING("Champagne/Sparkling wine"),
    ROSE("Rose wine");

    private final String type;
}
