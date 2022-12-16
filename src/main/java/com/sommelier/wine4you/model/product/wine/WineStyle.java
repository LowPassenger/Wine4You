package com.sommelier.wine4you.model.product.wine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WineStyle {
    OAK("Oak"),
    BRUT("Brut"),
    DRY("Dry"),
    SEMI_SWEET("Semi sweet"),
    SWEET("Sweet"),
    CONCENTRATED("Concentrated"),
    ELEGANT("Elegant"),
    INTENSE("Intense"),
    CRISP("Crisp"),
    OFF_DRY("Off-dry"),
    FRESH("Fresh"),
    FRUITY("Fruity");

    private final String style;
}
