package com.example.ECommerce.services;

import com.example.ECommerce.entities.Product;
import com.example.ECommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
       return this.productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return this.productRepository.findById(id);
    }

    public Optional<Product> getProductByName(String productName) {
        return this.productRepository.findByProductName(productName);
    }

    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    public Optional<Product> updateProduct(Product product) {
        Long productId = product.getProductId();
        Optional<Product> p = this.productRepository.findById(productId);
        if(p.isPresent()) {
            this.productRepository.save(product);
        }
        else {
            return Optional.empty();
        }

        return p;
    }

    public boolean deleteProduct(Long id) {
        if(this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
