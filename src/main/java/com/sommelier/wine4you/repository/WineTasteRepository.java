package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.WineTaste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WineTasteRepository extends JpaRepository<WineTaste, Long> {
    Optional<WineTaste> findByNameTasty(String nameTasty);
}
