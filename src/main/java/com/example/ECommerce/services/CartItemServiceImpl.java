package com.example.ECommerce.services;

import com.example.ECommerce.dto.CartItemsDto;
import com.example.ECommerce.entities.CartItem;
import com.example.ECommerce.repositories.CartRepo;
import com.example.ECommerce.repositories.CartItemRepo;
import com.example.ECommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    public CartItemRepo cartItemRepo;

    @Autowired
    public CartRepo cartRepo;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public ProductRepository productRepo;

    @Override
    public List<CartItemsDto> addItemtoCart(Long productId, Long cartId){
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


        //modelMapper.map(cartItem, CartItemsDto.class);

        List<CartItemsDto> cartItemsDtos = cartItemRepo.findByCartId(cartId).stream()
                .map(cartItem2 -> modelMapper.map(cartItem2,CartItemsDto.class))
                .collect(Collectors.toList());

        return cartItemsDtos;
    }

    @Override
    public boolean deleteItemfromCart(Long productId, Long cartId){
        Optional<CartItem> cartItem = Optional.of(new CartItem());
        cartItem = cartItemRepo.findByProductIdAndCartId(productId,cartId);
        if(!cartItem.isEmpty()){
            cartItemRepo.deleteByProductIdAndCartId(productId,cartId);
            return true;
        }
        return false;
    }

    @Override
    public List<CartItemsDto> showAlltheProducts(Long cartId){
        List<CartItemsDto> cartItemsDtos = cartItemRepo.findByCartId(cartId).stream()
                .map(cartItem -> modelMapper.map(cartItem,CartItemsDto.class))
                .collect(Collectors.toList());
        return cartItemsDtos;
    }
}

