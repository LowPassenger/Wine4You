package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.dto.WineResponse;
import com.sommelier.wine4you.model.dto.wine.WineResponseDto;
import java.math.BigDecimal;
import java.util.List;

public interface WineService {
    Wine create(Wine wine);

    Wine getById(Long id);

    List<WineResponseDto> getAll();

    WineResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir);

    Wine update(Long id, Wine wine);

    void deleteById(Long id);

    List<Wine> getAllByBrand(String brand);

    List<Wine> getAllByName(String name);

    List<Wine> getWinesByPriceBetween(BigDecimal priceMin, BigDecimal priceMax);

    List<Wine> getByCountry(String country);

    List<Wine> getByEvent(String event);

    List<Wine> getByWineStyle(String style);

    List<Wine> getByWineType(String type);

    List<Wine> getByWineTaste(String taste);
}
