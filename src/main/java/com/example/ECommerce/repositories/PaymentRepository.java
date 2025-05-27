package com.example.ECommerce.repositories;

import com.example.ECommerce.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payments, Long> {
}
