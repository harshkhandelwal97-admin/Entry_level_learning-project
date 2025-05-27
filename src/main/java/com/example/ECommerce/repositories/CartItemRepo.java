package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ECommerce.entities.CartItem;

import java.util.Optional;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long>{
    Optional<CartItem> findByProductIdAndCartId(Long productId, Long cartId);
}
