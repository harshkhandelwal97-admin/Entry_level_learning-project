package com.example.ECommerce.repositories;

import com.example.ECommerce.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductInterface extends CrudRepository<Product, Integer> {


}
