package com.sommelier.wine4you.service.impl;

import com.sommelier.wine4you.exception.ResourceNotFoundException;
import com.sommelier.wine4you.model.Event;
import com.sommelier.wine4you.model.Meal;
import com.sommelier.wine4you.model.Wine;
import com.sommelier.wine4you.model.WineStyle;
import com.sommelier.wine4you.model.WineTaste;
import com.sommelier.wine4you.model.dto.WineResponse;
import com.sommelier.wine4you.model.dto.wine.WineResponseDto;
import com.sommelier.wine4you.model.enums.WineType;
import com.sommelier.wine4you.model.mapper.impl.WineMapperImpl;
import com.sommelier.wine4you.repository.EventRepository;
import com.sommelier.wine4you.repository.ImageDbRepository;
import com.sommelier.wine4you.repository.MealRepository;
import com.sommelier.wine4you.repository.WineRepository;
import com.sommelier.wine4you.repository.WineStyleRepository;
import com.sommelier.wine4you.repository.WineTasteRepository;
import com.sommelier.wine4you.service.WineService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

class WineServiceImplTest {
    private static final Long testId = 9L;
    private static final Long fakeId = 300L;
    private static final Wine testWine = new Wine();
    private static final Wine wine = new Wine();
    private static final WineType testWineType = WineType.RED;
    private static final WineType testAnotherWineType = WineType.CHAMPAGNE_SPARKLING;
    private static final WineStyle testStyle = new WineStyle();
    private static final String testStyleName = "Dry";
    private static final WineTaste testTaste = new WineTaste();
    private static final String testTasteName = "Peach";
    private static final Event testEvent = new Event();
    private static final String testEventName = "Birthday";
    private static final Meal testMeal = new Meal();
    private static final String testMealName = "Cheese";
    private static final String testCountry = "Argentina";
    private static final String testName = "Pinot Noir";
    private static final String testBrand = "Domaine Loubejac";
    private static final BigDecimal testPriceMin = BigDecimal.valueOf(200);
    private static final BigDecimal testPriceMax = BigDecimal.valueOf(950);
    private WineRepository wineRepository;
    private EventRepository eventRepository;
    private WineStyleRepository wineStyleRepository;
    private WineTasteRepository wineTasteRepository;
    private MealRepository mealRepository;
    private ImageDbRepository imageDbRepository;
    private WineMapperImpl wineMapper;
    private WineService wineService;

    @BeforeEach
    void setUp() {
        wineRepository = Mockito.spy(WineRepository.class);
        eventRepository = Mockito.spy(EventRepository.class);
        wineStyleRepository = Mockito.spy(WineStyleRepository.class);
        wineTasteRepository = Mockito.spy(WineTasteRepository.class);
        mealRepository = Mockito.spy(MealRepository.class);
        imageDbRepository = Mockito.spy(ImageDbRepository.class);
        wineMapper = Mockito.mock(WineMapperImpl.class);
        wineService = new WineServiceImpl(wineRepository, eventRepository,wineStyleRepository,
                wineTasteRepository, mealRepository, imageDbRepository, wineMapper);
        testWine.setId(testId);
        testWine.setWineType(testWineType);
        testWine.setCountry(testCountry);
        testWine.setName(testName);
        testWine.setBrand(testBrand);
    }

    @Test
    void createWine_Ok() {
        wine.setWineType(testWineType);
        wine.setCountry(testCountry);
        wine.setName(testName);
        wine.setBrand(testBrand);
        Mockito.when(wineRepository.save(wine)).thenReturn(testWine);
        Wine actual = wineService.create(wine);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testId, actual.getId());
        Assertions.assertEquals(testWineType, actual.getWineType());
        Assertions.assertEquals(testBrand, actual.getBrand());
        Assertions.assertEquals(testName, actual.getName());
        Assertions.assertEquals(testCountry, actual.getCountry());
    }

    @Test
    void getWineById_Ok() {
        Mockito.when(wineRepository.findById(testId)).thenReturn(Optional.of(testWine));
        Wine actual = wineService.getById(testId);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testId, actual.getId());
        Assertions.assertEquals(testWineType, actual.getWineType());
        Assertions.assertEquals(testBrand, actual.getBrand());
        Assertions.assertEquals(testName, actual.getName());
        Assertions.assertEquals(testCountry, actual.getCountry());
    }

    @Test
    void getWineById_NotFound_NotOk() {
        try {
            wineService.getById(fakeId);
        } catch (RuntimeException e) {
            Assertions.assertEquals("Wine not found with id : '"
                    + fakeId + "'", e.getMessage());
        }
    }

    @Test
    void updateWine_Ok() {
        wine.setId(testId);
        wine.setWineType(testAnotherWineType);
        wine.setCountry(testCountry);
        wine.setName(testName);
        wine.setBrand(testBrand);
        wine.setPrice(testPriceMax);
        Mockito.when(wineRepository.save(wine)).thenReturn(wine);
        Wine actual = wineService.update(testId, wine);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testId, actual.getId());
        Assertions.assertEquals(testAnotherWineType, actual.getWineType());
        Assertions.assertEquals(testCountry, actual.getCountry());
        Assertions.assertEquals(testName, actual.getName());
        Assertions.assertEquals(testBrand, actual.getBrand());
        Assertions.assertEquals(testPriceMax, actual.getPrice());
    }

    @Test
    void getAll_WineResponse_Ok() {
        WineResponseDto wineResponseDto = Mockito.mock(WineResponseDto.class);
        List<WineResponseDto> responseList = List.of(wineResponseDto);
        Pageable pageable = Mockito.mock(Pageable.class);
        //Mockito.when(wineRepository.findAll(pageable)).thenReturn(wines);
        Page<Wine> wines = Mockito.spy(wineRepository.findAll(pageable));
        //Mockito.when(wines.getContent()).thenReturn(List.of(testWine));
        //List<Wine> wineList = Mockito.spy(wines.getContent());
        WineResponse wineResponse = new WineResponse();
        wineResponse.setContent(List.of(wineResponseDto));
        wineResponse.setLast(false);
        wineResponse.setPageNo(1);
        wineResponse.setPageSize(9);
        wineResponse.setTotalPages(4);
        wineResponse.setTotalElements(27);
        Mockito.when(wineRepository.findAll(pageable)).thenReturn(wines);
        WineResponse actual = wineService.getAll(9, 4, "WineStyle", "ASC");
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(responseList, actual.getContent());
        Assertions.assertFalse(actual.isLast());
        Assertions.assertEquals(1, actual.getPageNo());
        Assertions.assertEquals(9, actual.getPageSize());
        Assertions.assertEquals(4, actual.getTotalPages());
        Assertions.assertEquals(27, actual.getTotalElements());
    }

    @Test
    void testGetAllWinesList_Ok() {
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineRepository.findAll()).thenReturn(testList);
        List<Wine> actual = wineService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void deleteWineById_Ok() {
        Mockito.when(wineRepository.findById(testId)).thenReturn(Optional.of(testWine));
        Assertions.assertFalse(wineService.deleteById(testId));
    }

    @Test
    void deleteWineById_NotFound_NotOk() {
        try {
            wineService.deleteById(fakeId);
        } catch (ResourceNotFoundException e) {
            Assertions.assertEquals("Wine not found with id : '300'", e.getMessage());
        }
    }

    @Test
    void getAllWinesByBrand_Ok() {
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineRepository.findByBrand(testBrand)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getAllByBrand(testBrand);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getAllWinesByBrand_NotFound_NotOk() {
        try {
            wineService.getAllByBrand("Fake");
        } catch (ResourceNotFoundException e) {
            Assertions.assertEquals("Wine not found with Brand : 'Fake'",
                    e.getMessage());
        }
    }

    @Test
    void getAllWinesByName_Ok() {
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineRepository.findByName(testName)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getAllByName(testName);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getAllWinesByName_NotFound_NotOk() {
        try {
            wineService.getAllByName("Fake");
        } catch (ResourceNotFoundException e) {
            Assertions.assertEquals("Wine not found with Name : 'Fake'",
                    e.getMessage());
        }
    }

    @Test
    void getWinesByPriceBetween_Ok() {
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineRepository.findByPriceBetween(testPriceMin, testPriceMax))
                .thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getWinesByPriceBetween(testPriceMin, testPriceMax);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getWinesByPriceBetweenNotFound_Ok() {
        List<Wine> testList = new ArrayList<>();
        Mockito.when(wineRepository.findByPriceBetween(BigDecimal.valueOf(0),
                        BigDecimal.valueOf(1)))
                .thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getWinesByPriceBetween(BigDecimal.valueOf(0),
                BigDecimal.valueOf(1));
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getWinesByCountry_Ok() {
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineRepository.findByCountry(testCountry)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getByCountry(testCountry);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getWinesByCountryNotFound_NotOk() {
        try {
            wineService.getByCountry("Fake");
        } catch (ResourceNotFoundException e) {
            Assertions.assertEquals("Wine not found with Country : 'Fake'",
                    e.getMessage());
        }
    }

    @Test
    void getWinesByEvent_Ok() {
        testEvent.setId(3L);
        testEvent.setNameEvent(testEventName);
        testWine.setEvent(testEvent);
        List<Wine> testList = List.of(testWine);
        Mockito.when(eventRepository.findByNameEvent(testEventName)).thenReturn(Optional.of(testEvent));
        Mockito.when(wineRepository.findByEvent(testEvent)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getByEvent(testEventName);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }


    @Test
    void getWinesByWineStyle_Ok() {
        testStyle.setNameStyle(testStyleName);
        testWine.setWineStyle(testStyle);
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineStyleRepository.findByNameStyle(testStyleName)).thenReturn(Optional.of(testStyle));
        Mockito.when(wineRepository.findByWineStyle(testStyle)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getByWineStyle(testStyleName);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getWinesByWineType_Ok() {
        testWine.setWineType(testWineType);
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineRepository.findByWineType(testWineType)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getByWineType("RED");
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getWinesByWineTaste_Ok() {
        testTaste.setNameTaste(testTasteName);
        testWine.setWineTaste(testTaste);
        List<Wine> testList = List.of(testWine);
        Mockito.when(wineTasteRepository.findByNameTaste(testTasteName))
                .thenReturn(Optional.of(testTaste));
        Mockito.when(wineRepository.findByWineTaste(testTaste)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getByWineTaste(testTasteName);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getWinesByWineTasteNotFound_NotOk() {
        try {
            wineService.getByWineTaste("Fake");
        } catch (ResourceNotFoundException e) {
            Assertions.assertEquals("WineTaste not found with Taste : 'Fake'",
                    e.getMessage());
        }
    }

    @Test
    void name() {
    }

    @Test
    void getWinesByMeal_Ok() {
        testMeal.setName(testMealName);
        testWine.setMeal(testMeal);
        List<Wine> testList = List.of(testWine);
        Mockito.when(mealRepository.findByName(testMealName)).thenReturn(Optional.of(testMeal));
        Mockito.when(wineRepository.findByMeal(testMeal)).thenReturn(Optional.of(testList));
        List<Wine> actual = wineService.getByMeal(testMealName);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    void getWinesByMealNameNotFound_NotOk() {
        try {
            wineService.getByMeal("Fake");
        } catch (ResourceNotFoundException e) {
            Assertions.assertEquals("Meal not found with mealName : 'Fake'",
                    e.getMessage());
        }
    }

    @Test
    void getWinesByMealNotFound_NotOk() {
        try {
            wineRepository.findByMeal(testMeal);
        } catch (ResourceNotFoundException e) {
            Assertions.assertEquals("Meal not found with mealName : 'Fake'",
                    e.getMessage());
        }
    }
}