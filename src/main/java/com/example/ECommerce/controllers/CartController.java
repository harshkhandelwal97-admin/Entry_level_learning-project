package com.example.ECommerce.controllers;

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
@RequestMapping("/api/user/{userid}/cart/{cartid}")
//add the following mappings in the controller
//1) Add to the Cart
//2) Delete from the cart
//3) Show the whole cart
public class CartController {
    //@PostMapping("/")
}
