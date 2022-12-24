package com.sommelier.wine4you.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterRepository<T> extends JpaRepository<T, Long> {
    Optional<T> findByName(String name);
}
