package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByNameEvent(String nameEvent);
}
