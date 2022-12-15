package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.Product;
import com.sommelier.wine4you.model.Wine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
    List<Product> findByBrand(String brand);
    List<Product> findByName(String name);
}
