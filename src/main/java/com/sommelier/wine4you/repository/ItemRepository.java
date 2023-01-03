package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.Item;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    default List<Item> findItemsByOrderId(Long id) {
        ItemRepository(SessionFactory factory) {

        }
        return null;
    };
}
