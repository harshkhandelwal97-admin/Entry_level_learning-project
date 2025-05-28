package com.example.ECommerce.repositories;

import com.example.ECommerce.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository <Payments, Long> {

}
