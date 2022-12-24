package com.sommelier.wine4you.controller;


import com.sommelier.wine4you.service.FilterService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Rest APIs for product filters")
@RestController
@RequestMapping("api/vi/filters")
public class FilterController {
    private final FilterService filterService;
    private final FilterMapper filterMapper;


}
