package com.sommelier.wine4you.service;

import com.sommelier.wine4you.model.Event;
import java.util.List;

public interface EventService {
    Event create(Event event);

    Event getById(Long id);

    List<Event> getAll();

    void deleteById(Long id);

    Event findByEventName(String name);

    Event update(Long id, Event event);
}
