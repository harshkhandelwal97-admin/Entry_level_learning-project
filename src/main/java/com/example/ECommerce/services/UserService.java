package com.example.ECommerce.services;

import com.example.ECommerce.entities.Cart;
import com.example.ECommerce.entities.User;
import com.example.ECommerce.repositories.CartRepo;
import com.example.ECommerce.repositories.CartItemRepo;
import com.example.ECommerce.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class UserService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo;

    public void addUser(User user){
        Cart cart = new Cart();
        user.setCart(cart);
        User savedUser = userRepo.save(user);
        cart.setUser(savedUser);
        cartRepo.save(cart);
    }
}
