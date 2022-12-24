package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.Event;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    Event create(Event event);

    Event getById(Long id);

    List<Event> getAll();

    void deleteById(Long id);

    Event findByEventName(String name);
}
