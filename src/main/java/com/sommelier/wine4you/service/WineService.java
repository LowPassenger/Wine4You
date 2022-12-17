package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.Wine;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface WineService {
    List<Wine> getAll();

    List<Wine> getAllByBrand(String brand);

    List<Wine> getAllByName(String name);

    List<Wine> getWinesByPriceBetween(BigDecimal priceMin, BigDecimal priceMax);

    List<Wine> findByCountry(String country);

    List<Wine> findByEvent(String event);

    List<Wine> findByWineStyle(String style);

    List<Wine> findByWineType(String type);

    List<Wine> findByWineTaste(String taste);
}
