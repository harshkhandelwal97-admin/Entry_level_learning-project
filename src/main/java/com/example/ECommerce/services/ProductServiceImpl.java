package com.example.ECommerce.services;

import com.example.ECommerce.entities.Product;
import com.example.ECommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return this.productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) {
        Long productId = product.getProductId();
        Optional<Product> p = this.productRepository.findById(productId);
        if (p.isPresent()) {
            this.productRepository.save(product);
        }
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
