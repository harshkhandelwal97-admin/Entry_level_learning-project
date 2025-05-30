package com.example.ECommerce.controllers;

import com.example.ECommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.ECommerce.services.UserService;
import com.example.ECommerce.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/auth")
public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/new")
//    public ResponseEntity<ApiResponse<Void>> createUser(@RequestBody User user) {
//        userService.addUser(user);
//        ApiResponse<Void> response = new ApiResponse<>(true, "User has been created", null);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(response);
//    }
@GetMapping("/welcome")
public String welcome() {
    return "Welcome, this endpoint is not secure";
}

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasRole('USER')")  // Use hasRole for role-based access control
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasRole('ADMIN')")  // Use hasRole for role-based access control
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
}
