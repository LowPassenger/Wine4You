package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.WineStyle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WineStyleRepository extends JpaRepository<WineStyle, Long> {
    Optional<WineStyle> findByNameStyle(String nameStyle);
}
