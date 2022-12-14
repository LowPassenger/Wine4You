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
    CONCENTRATED("Concentrated");

    private final String style;
}
