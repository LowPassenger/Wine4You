package com.sommelier.wine4you.model.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sommelier.wine4you.model.Event;
import com.sommelier.wine4you.model.dto.event.EventRequestDto;
import com.sommelier.wine4you.model.dto.event.EventResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventMapperImplTest {
    private EventMapperImpl eventMapper;
    private Event event;
    private EventResponseDto responseDto;
    private EventRequestDto requestDto;

    @BeforeEach
    void setUp() {
        eventMapper = new EventMapperImpl();
        event = new Event();
        event.setId(1L);
        event.setNameEvent("Marriage");

        responseDto = new EventResponseDto();
        responseDto.setId(1L);
        responseDto.setNameEvent("Marriage");

        requestDto = new EventRequestDto();
        requestDto.setNameEvent("Marriage");

    }

    @Test
    void toDto_Ok() {
        EventResponseDto actual = eventMapper.toDto(event);
        assertEquals(responseDto, actual);
    }

    @Test
    void toModel_Ok() {
        Event actual = eventMapper.toModel(requestDto);
        assertEquals(event.getNameEvent(), actual.getNameEvent());
    }
}
