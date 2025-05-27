package com.example.ECommerce.repositories;

import com.example.ECommerce.entities.Cart;
import com.example.ECommerce.entities.CartItem;
import com.example.ECommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long>{
    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.cartId = ?1 AND ci.product.productId = ?2")
    Optional<CartItem> findByProductIdAndCartId(Long productId, Long cartId);
}
