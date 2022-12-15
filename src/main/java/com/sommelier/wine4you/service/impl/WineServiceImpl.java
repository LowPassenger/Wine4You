package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.repository.WineRepository;
import com.sommelier.wine4you.service.WineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;

    @Autowired
    public WineServiceImpl(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> getAll() {
        return wineRepository.findAll();
    }

    @Override
    public List<Wine> getAllByBrand(String brand) {
        return null;
    }

    @Override
    public List<Wine> getAllByName(String name) {
        return null;
    }
}
