package com.example.ECommerce.controllers;

import com.example.ECommerce.dto.ApiResponse;
import com.example.ECommerce.dto.ProductDTO;
import com.example.ECommerce.entities.Product;
import com.example.ECommerce.services.ProductService;
import com.example.ECommerce.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(@RequestBody Product product) {
        ProductDTO savedProduct = productService.createProduct(product);
        ApiResponse<ProductDTO> response = new ApiResponse<>(
                true,
                "New product created successfully",
                savedProduct
        );
        return ResponseEntity.created(URI.create("/api/products/" + savedProduct.getProductId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        Optional<ProductDTO> productOpt = productService.getProductById(id);
        return productOpt.isPresent() ? ResponseEntity.ok().body(new ApiResponse<>(
                true,
                "Product fetched successfully",
                productOpt.orElse(null))
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Product not available", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<ProductDTO>> getProductByName(@RequestParam(name = "product_name") String productName) {
        Optional<ProductDTO> productOpt = productService.getProductByName(productName);
        return productOpt.isPresent() ? ResponseEntity.ok().body(new ApiResponse<>(
                true,
                "Product fetched successfully",
                productOpt.orElse(null)
        )) :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Product not available", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProductById(@PathVariable Long id, @RequestBody Product product) {
        Optional<ProductDTO> productOpt = productService.getProductById(id);
        if (productOpt.isPresent()) {
            productService.updateProduct(product);}
        return productOpt.map(value ->
            ResponseEntity.ok().body(new ApiResponse<>(
                true,
                "Product updated successfully",
                value
        ))).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Product not available", null)));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts() {
        List<ProductDTO> products =  productService.getAllProduct();
        String message = products.isEmpty() ? "No products available" : "Products listed below";
        ApiResponse<List<ProductDTO>> response = new ApiResponse<>(true, message, products);
        return ResponseEntity
                .ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> deleteProductById(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if(isDeleted) {
            return ResponseEntity.ok().body(new ApiResponse<>(true, "Product deleted successfully", null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Cannot find the product", null));
    }

}
