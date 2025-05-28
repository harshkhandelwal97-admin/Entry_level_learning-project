package com.example.ECommerce.services;

import com.example.ECommerce.dto.ProductDTO;
import com.example.ECommerce.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDTO createProduct(Product product);

    Optional<ProductDTO> getProductById(Long id);

    Optional<ProductDTO> getProductByName(String productName);

    List<ProductDTO> getAllProduct();

    void updateProduct(Product product);

    boolean deleteProduct(Long id);
}
