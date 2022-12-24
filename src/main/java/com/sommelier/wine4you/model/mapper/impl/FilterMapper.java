package com.sommelier.wine4you.model.mapper.impl;

import com.sommelier.wine4you.model.dto.FilterRequestDto;
import com.sommelier.wine4you.model.dto.FilterResponseDto;
import com.sommelier.wine4you.model.mapper.GenericMapper;

public class FilterMapper<T> implements GenericMapper<FilterResponseDto, T, FilterRequestDto> {
    @Override
    public FilterResponseDto toDto(T t) {
        FilterResponseDto responseDto = new FilterResponseDto();
        return responseDto.setId(t.getId());
    }

    @Override
    public T toModel(FilterRequestDto filterRequestDto) {
        T t = new T();
        return null;
    }
}
