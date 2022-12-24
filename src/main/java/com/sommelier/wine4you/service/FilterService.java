package com.sommelier.wine4you.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface FilterService<T> {
    T create(T t);
    Optional<T> findById(Long id);
    List getAll();
    void deleteById(Long id);
    T findByName(String name);
}
