package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.WineStyle;
import java.util.List;

public interface WineStyleService {
    WineStyle create(WineStyle wineStyle);

    WineStyle getById(Long id);

    List<WineStyle> getAll();

    void deleteById(Long id);

    WineStyle findByStyleName(String name);

    WineStyle update(Long id, WineStyle style);
}
