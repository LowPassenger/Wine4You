package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.exception.ResourceNotFoundException;
import com.sommelier.wine4you.model.Item;
import com.sommelier.wine4you.repository.ItemRepository;
import com.sommelier.wine4you.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Item", "id", String.valueOf(id)));
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getAllByOrderId(Long id) {
        return itemRepository.findItemsById(id);
    }

    @Override
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item findByName(String name) {
        return null;
    }

    @Override
    public Item update(Long id, Item item) {
        return null;
    }
}
