package com.example.ECommerce.services;

import com.example.ECommerce.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional<Product> getProductById(Long id);

    Optional<Product> getProductByName(String productName);

    List<Product> getAllProduct();

    void updateProduct(Product product);

    boolean deleteProduct(Long id);
}
