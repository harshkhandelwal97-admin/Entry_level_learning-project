package com.example.ECommerce.services;

import com.example.ECommerce.entities.User;
import com.example.ECommerce.entities.Product;
import com.example.ECommerce.entities.Cart;
import com.example.ECommerce.entities.CartItem;
import com.example.ECommerce.dto.CartDto;
import com.example.ECommerce.dto.UserDto;
import com.example.ECommerce.repositories.CartRepo;
import com.example.ECommerce.repositories.CartItemRepo;
import com.example.ECommerce.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo;

    private void addacart(Long userId){
        Optional<Cart> cart = cartRepo.findByUserId(userId);
        if(cart.isEmpty()){
            Cart cart1 = new Cart();
            cart1.setUser(userRepo.findById(userId).get());
            cartRepo.save(cart1);
        }
    }
}
