package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.exception.ResourceNotFoundException;
import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.enums.Event;
import com.sommelier.wine4you.model.enums.WineStyle;
import com.sommelier.wine4you.model.enums.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import com.sommelier.wine4you.repository.WineRepository;
import com.sommelier.wine4you.service.WineService;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;

    @Autowired
    public WineServiceImpl(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public Wine findById(Long id) {
        return wineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "id", String.valueOf(id))
        );
    }

    @Override
    public void deleteById(Long id) {
        Wine wine = wineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "id", String.valueOf(id))
        );
        wineRepository.delete(wine);
        log.info("Successfully, delete wine by id {}", id);
    }

    @Override
    public List<Wine> getAll() {
        return wineRepository.findAll();
    }

    @Override
    public List<Wine> getAllByBrand(String brand) {
        List<Wine> wines = wineRepository.findAll();
        if (!wines.isEmpty()) {
            return wineRepository.findByBrand(brand);
        }
        throw new ResourceNotFoundException("Wine", "Brand", brand);
    }

    @Override
    public List<Wine> getAllByName(String name) {
        return wineRepository.findByName(name);
    }

    @Override
    public List<Wine> getWinesByPriceBetween(BigDecimal priceMin, BigDecimal priceMax) {
        return wineRepository.findByPriceBetween(priceMin, priceMax);
    }

    @Override
    public List<Wine> findByCountry(String country) {
        return wineRepository.findByCountry(country);
    }

    @Override
    public List<Wine> findByEvent(String event) {
        return wineRepository.findByEvent(Event.valueOf(event));
    }

    @Override
    public List<Wine> findByWineStyle(String style) {
        return wineRepository.findByWineStyle(WineStyle.valueOf(style));
    }

    @Override
    public List<Wine> findByWineType(String type) {
        return wineRepository.findByWineType(WineType.valueOf(type));
    }

    @Override
    public List<Wine> findByWineTaste(String taste) {
        return wineRepository.findByWineTaste(WineTaste.valueOf(taste));
    }
}
