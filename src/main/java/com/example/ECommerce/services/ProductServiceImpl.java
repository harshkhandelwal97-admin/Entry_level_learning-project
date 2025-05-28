package com.example.ECommerce.services;

import com.example.ECommerce.dto.ProductDTO;
import com.example.ECommerce.entities.Product;
import com.example.ECommerce.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO createProduct(Product product) {
        this.productRepository.save(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.map(value -> modelMapper.map(value, ProductDTO.class));
    }

    @Override
    public Optional<ProductDTO> getProductByName(String productName) {
        Optional<Product> product = this.productRepository.findByProductName(productName);
        return product.map(value -> modelMapper.map(value, ProductDTO.class));
    }

    @Override
    public List<ProductDTO> getAllProduct() {

        List<Product> products = productRepository.findAll();

        return  products.stream().map(value -> modelMapper.map(value, ProductDTO.class)).collect(Collectors.toList());
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
