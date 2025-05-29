package com.example.ECommerce.controllers;

import com.example.ECommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ECommerce.services.UserService;
import com.example.ECommerce.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<Void>> createUser(@RequestBody User user) {
        userService.addUser(user);
        ApiResponse<Void> response = new ApiResponse<>(true, "User has been created", null);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
