package com.example.ECommerce.repositories;

import com.example.ECommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long>{
    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.cartId = ?2 AND ci.product.productId = ?1")
    Optional<CartItem> findByProductIdAndCartId(Long productId, Long cartId);

    @Query("SELECT ci FROM CartItem ci WHERE ci.cart.cartId =?1")
    List<CartItem> findByCartId(Long cartId);

    @Modifying
    @Query("DELETE FROM CartItem ci WHERE ci.cart.cartId = ?2 AND ci.product.productId = ?1")
    void deleteByProductIdAndCartId(Long productId, Long cartId);
}