package com.example.ECommerce.repositories;

import com.example.ECommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{
    @Query("SELECT ci FROM Cart ci WHERE ci.user.user_id=?1")
    Optional<Cart> findByUserId(Long userId);
}
