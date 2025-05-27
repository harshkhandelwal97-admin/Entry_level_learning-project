package com.example.ECommerce.dto;

import com.example.ECommerce.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemsDto {
    private Long cartItemId;
    private CartDto cart;
    private ProductDTO product;
    private int quantity;
}
