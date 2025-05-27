package com.example.ECommerce.services;

import com.example.ECommerce.dto.CartItemsDto;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface CartItemService {

    List<CartItemsDto> addItemtoCart(Long productId, Long cartId);
    boolean deleteItemfromCart(Long productId, Long cartId);
    List<CartItemsDto> showAlltheProducts(Long cartId);
}
