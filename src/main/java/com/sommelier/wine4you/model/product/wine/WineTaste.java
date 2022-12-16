package com.sommelier.wine4you.model.product.wine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WineTaste {
    TROPICAL("Tropical"),
    BLACKBERRY("Blackberry"),
    CHOCOLATE("Chocolate"),
    VANILLA("Vanilla"),
    DRIED_CHERRY("Dried Cherry"),
    BLACK_CURRANT("Black Currant"),
    CHERRY("Cherry"),
    STRAWBERRY("Strawberry"),
    BLACK_FRUIT("Black Fruit"),
    SPICE("Spice"),
    RED_BERRY("Red Berry"),
    CRANBERRY("Cranberry"),
    CURRANT("Currant"),
    DARK_BERRY("Dark Berry"),
    RED_FRUIT("Red Fruit"),
    VIOLET("Violet"),
    PLUM("Plum"),
    LICORICE("Licorice"),
    BLACK_CHERRY("Black Cherry"),
    SAGE("Sage"),
    HERB("Herb"),
    BUTTER("Butter"),
    PEAR("Pear"),
    PASSIONFRUIT("Passionfruit"),
    GOOSEBERRY("Gooseberry"),
    CITRUS("Citrus"),
    APRICOT("Apricot"),
    STONE_FRUIT("Stone Fruit"),
    PEACH("Peach"),
    MELON("Melon"),
    ALMOND("Almond"),
    APPLE("Apple"),
    MANGO("Mango"),
    LIME("Lime"),
    FLORAL("Floral"),
    MINERAL("Mineral"),
    WHITE_PEACH("White Peach"),
    FIG("Fig"),
    WHITE_FRUIT("White Fruit"),
    TOAST("Toast"),
    GREEN_APPLE("Green Apple"),
    RED_CHERRY("Red Cherry"),
    BERRY("Berry"),
    FRUITY("Fruity"),
    RASPBERRY("Raspberry"),
    CASSIS("Cassis");

    private final String taste;
}
