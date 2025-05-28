package com.example.ECommerce.controllers;

import com.example.ECommerce.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ECommerce.dto.CartItemsDto;
import com.example.ECommerce.dto.ApiResponse;
import com.example.ECommerce.services.CartItemService;
import com.example.ECommerce.services.CartItemServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//add the following mappings in the controller
//1) Add to the Cart
//2) Delete from the cart
//3) Show the whole cart
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/user/{userid}/cart/{cartid}")
    public ResponseEntity<ApiResponse<List<CartItemsDto>>> getCart(@PathVariable Long cartid) {
        List<CartItemsDto> cartDtoList = cartItemService.showAlltheProducts(cartid);
        String message = cartDtoList.isEmpty() ? "No cart found" : "Below are the products in the cart";
        ApiResponse<List<CartItemsDto>> apiResponse = new ApiResponse<>(true, message, cartDtoList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
