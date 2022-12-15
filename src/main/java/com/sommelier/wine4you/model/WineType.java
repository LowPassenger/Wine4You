package com.sommelier.wine4you.model;

public enum WineType {
    WHITE("White"),
    RED("Red"),
    CHAMPAGNE_SPARKLING("Champagne sparkling"),
    ROSE("Rose");

    private String value;

    WineType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
