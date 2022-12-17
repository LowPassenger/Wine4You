package com.sommelier.wine4you.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Event {
    NEW_YEAR("New year"),
    PARTY("Party"),
    BIRTHDAY("Birthday"),
    CORPORATE("Corporate event");
    
    private final String event;
}
