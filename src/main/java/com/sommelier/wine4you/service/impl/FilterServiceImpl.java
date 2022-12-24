package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.repository.FilterRepository;
import com.sommelier.wine4you.service.FilterService;
import java.util.List;
import java.util.Optional;

public class FilterServiceImpl<T> implements FilterService {
    private final FilterRepository filterRepository;
    private final Class<T> clazz;

    public FilterServiceImpl(FilterRepository filterRepository, Class<T> clazz) {
        this.filterRepository = filterRepository;
        this.clazz = clazz;
    }

    @Override
    public T create(Object t) {
        return (T)filterRepository.save(t);
    }

    @Override
    public Optional<T> findById(Long id) {
        return filterRepository.findById(id);
    }

    @Override
    public List getAll() {
        return filterRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public Optional<T> findByName(String name) {
            return filterRepository.findByName(name);
    }

}
