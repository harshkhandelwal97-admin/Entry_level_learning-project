package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ECommerce.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{

}
