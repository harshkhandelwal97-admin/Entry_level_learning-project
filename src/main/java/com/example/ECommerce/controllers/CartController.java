package com.example.ECommerce.controllers;

import com.example.ECommerce.repositories.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ECommerce.repositories.ProductRepository;
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
    private CartRepo cartRepo;

    @Autowired
    private CartItemServiceImpl cartItemService;

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("/userId/{userId}/cart/{cartid}")
    public ResponseEntity<ApiResponse<List<CartItemsDto>>> getCart(@PathVariable Long userId, @PathVariable Long cartid) {
        List<CartItemsDto> cartDtoList = cartItemService.showAlltheProducts(cartid);
        String message = cartDtoList.isEmpty() ? "No cart found" : "Below are the products in the cart";
        ApiResponse<List<CartItemsDto>> apiResponse = new ApiResponse<>(true, message, cartDtoList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/product/{productId}/cart/{cartId}")
    public ResponseEntity<ApiResponse<List<CartItemsDto>>> addtoCart(@PathVariable Long productId, @PathVariable Long cartId) {
        List<CartItemsDto> cartItemsDtos = cartItemService.addItemtoCart(productId, cartId);
        String message = "Product " + productRepo.findById(productId).get().getProductName() + " added to cart ";
        ApiResponse<List<CartItemsDto>> apiResponse = new ApiResponse<>(true, message, cartItemsDtos);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponse);
    }

}
