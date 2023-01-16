package com.sommelier.wine4you.model.enums;

public enum PaymentType {
    ONLINE("On-line 'Visa/MasterCard'"),
    CASH("€, $, UAH");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
