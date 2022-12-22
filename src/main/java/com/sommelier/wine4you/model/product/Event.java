package com.sommelier.wine4you.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Event {
    NEW_YEAR("New year"),
    PARTY("Party"),
    BIRTHDAY("Birthday"),
    CORPORATE_EVENT("Corporate event");

   private final String event;
}
