package com.example.ECommerce.services;

import com.example.ECommerce.entities.User;
import com.example.ECommerce.entities.Product;
import com.example.ECommerce.entities.Cart;
import com.example.ECommerce.entities.CartItem;
import com.example.ECommerce.dto.CartDto;
import com.example.ECommerce.dto.UserDto;
import com.example.ECommerce.repositories.CartRepo;
import com.example.ECommerce.repositories.CartItemRepo;
import com.example.ECommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepository productRepo;

    private void addItem(Long productId, Long cartId){
        Optional<CartItem> cartItem = Optional.of(new CartItem());
        cartItem = cartItemRepo.findByProductIdAndCartId(productId,cartId);
        if(cartItem.isEmpty()){
            CartItem cartItem1 = new CartItem();
            cartItem1.setProduct(productRepo.findById(productId).get());
            cartItem1.setCart(cartRepo.findById(cartId).get());
            cartItem1.setQuantity(1L);
        }
        else{
            Long quant = cartItem.get().getQuantity();
            cartItem.get().setQuantity(quant+1);
        }
    }
}
