package com.sommelier.wine4you.model;

public enum WineStyle {
    OAK("Oak"),
    BRUT("Brut"),
    DRY("Dry"),
    SEMI_SWEET("Semi sweet"),
    SWEET("Sweet"),
    CONCENTRATED("Concentrated");

    private String value;

    WineStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
