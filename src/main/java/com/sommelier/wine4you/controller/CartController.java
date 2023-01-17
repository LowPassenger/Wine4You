package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.Cart;
import com.sommelier.wine4you.model.dto.shoppingcart.CartRequestDto;
import com.sommelier.wine4you.model.dto.shoppingcart.CartResponseDto;
import com.sommelier.wine4you.model.mapper.impl.CartMapperImpl;
import com.sommelier.wine4you.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Rest APIs for Cart resources")
@RestController
@RequestMapping("api/v1/carts")
public class CartController {
    private final CartService cartService;
    private final CartMapperImpl cartMapper;

    @Autowired
    public CartController(CartService cartService,
                          CartMapperImpl cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @ApiOperation(value = "Create Cart REST API")
    @PostMapping
    public ResponseEntity<String> create(
            @Valid @RequestBody CartRequestDto cartRequestDto) {
        return new ResponseEntity<>("Cart created, successfully !",
                HttpStatus.CREATED);
    }
}
