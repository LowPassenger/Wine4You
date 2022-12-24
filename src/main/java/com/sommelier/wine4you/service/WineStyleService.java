package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.WineStyle;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface WineStyleService {
    WineStyle create(WineStyle wineStyle);

    WineStyle getById(Long id);

    List<WineStyle> getAll();

    void deleteById(Long id);

    WineStyle findByTasteName(String name);
}
