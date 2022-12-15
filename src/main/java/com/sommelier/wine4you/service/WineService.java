package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.Wine;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface WineService {
    List<Wine> getAll();
    List<Wine> getAllByBrand(String brand);
    List<Wine> getAllByName(String name);
}
