package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.exception.ResourceNotFoundException;
import com.sommelier.wine4you.model.*;
import com.sommelier.wine4you.model.dto.WineRequestDto;
import com.sommelier.wine4you.model.dto.WineResponseDto;
import com.sommelier.wine4you.model.enums.WineType;
import com.sommelier.wine4you.model.mapper.impl.WineMapperImpl;
import com.sommelier.wine4you.repository.EventRepository;
import com.sommelier.wine4you.repository.WineRepository;
import com.sommelier.wine4you.repository.WineStyleRepository;
import com.sommelier.wine4you.repository.WineTasteRepository;
import com.sommelier.wine4you.service.WineService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;
    private final EventRepository eventRepository;
    private final WineStyleRepository styleRepository;
    private final WineTasteRepository tasteRepository;
    private final WineMapperImpl wineMapper;

    @Autowired
    public WineServiceImpl(WineRepository wineRepository,
                           EventRepository eventRepository,
                           WineStyleRepository styleRepository,
                           WineTasteRepository tasteRepository, WineMapperImpl wineMapper) {
        this.wineRepository = wineRepository;
        this.styleRepository = styleRepository;
        this.eventRepository = eventRepository;
        this.tasteRepository = tasteRepository;
        this.wineMapper = wineMapper;
    }

    @Override
    public Wine create(Wine wine) {
        return wineRepository.save(wine);
    }

    @Override
    public Wine getById(Long id) {
        return wineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "id", String.valueOf(id))
        );
    }

    @Override
    public Wine update(Long id, Wine wine) {
        wine.setId(id);
        return wineRepository.save(wine);
    }

    @Override
    public void deleteById(Long id) {
        Wine wine = wineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "id", String.valueOf(id))
        );
        wineRepository.delete(wine);
        log.info("Successfully, delete wine by id {}", id);
    }

    @Override
    public WineResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Wine> wines = wineRepository.findAll(pageable);
        List<Wine> wineList = wines.getContent();

        List<WineResponseDto> content = wineList.stream()
                .map(wineMapper::toDto)
                .collect(Collectors.toList());

        return getWineResponse(wines, content);
    }

    private static WineResponse getWineResponse(Page<Wine> wines, List<WineResponseDto> content) {
        WineResponse wineResponse = new WineResponse();
        wineResponse.setContent(content);
        wineResponse.setPageNo(wines.getNumber());
        wineResponse.setPageSize(wines.getSize());
        wineResponse.setTotalElements(wines.getTotalElements());
        wineResponse.setTotalPages(wines.getTotalPages());
        wineResponse.setLast(wines.isLast());
        return wineResponse;
    }

    @Override
    public List<Wine> getAllByBrand(String brand) {
        return wineRepository.findByBrand(brand).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Brand", brand));
    }

    @Override
    public List<Wine> getAllByName(String name) {
        return wineRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Name", name));
    }

    @Override
    public List<Wine> getWinesByPriceBetween(BigDecimal priceMin, BigDecimal priceMax) {
        return wineRepository.findByPriceBetween(priceMin, priceMax).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Price", "range(" + priceMin + ", " + priceMax)
        );
    }

    @Override
    public List<Wine> getByCountry(String country) {
        return wineRepository.findByCountry(country).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Country", country)
        );
    }

    @Override
    public List<Wine> getByEvent(String event) {
        Event findEvent = eventRepository.findByNameEvent(event).orElseThrow(
                () -> new ResourceNotFoundException("Event", "EventName", event)
        );
        return wineRepository.findByEvent(findEvent).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Event", event));
    }

    @Override
    public List<Wine> getByWineStyle(String style) {
        WineStyle wineStyle = styleRepository.findByNameStyle(style).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Style", style)
        );
        return wineRepository.findByWineStyle(wineStyle).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Style", style)
        );
    }

    @Override
    public List<Wine> getByWineType(String type) {
        return wineRepository.findByWineType(WineType.valueOf(type)).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Type", type)
        );
    }

    @Override
    public List<Wine> getByWineTaste(String taste) {
        WineTaste wineTaste = tasteRepository.findByNameTasty(taste).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Taste", taste)
        );
        return wineRepository.findByWineTaste(wineTaste).orElseThrow(
                () -> new ResourceNotFoundException("Wine", "Taste", taste)
        );
    }
}
