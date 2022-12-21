package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.Event;
import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.WineStyle;
import com.sommelier.wine4you.model.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
    List<Wine> findByBrand(String brand);

    List<Wine> findByName(String name);

    List<Wine> findByPriceBetween(BigDecimal priceMin, BigDecimal priceMax);

    List<Wine> findByCountry(String country);

    List<Wine> findByEvent(Event event);

    List<Wine> findByWineStyle(WineStyle wineStyle);

    List<Wine> findByWineType(WineType wineType);

    List<Wine> findByWineTaste(WineTaste wineTaste);
}
