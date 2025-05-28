package com.example.ECommerce.controllers;

import com.example.ECommerce.dto.PaymentRequest;
import com.example.ECommerce.entities.Payments;
import com.example.ECommerce.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/paymentDetails")
    public ResponseEntity<Payments> processPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            Payments payment = paymentService.processPayment(paymentRequest);
            return ResponseEntity.ok(payment);
        } catch (RuntimeException e) {
            // For simplicity, returning bad request with the error message
            return ResponseEntity.badRequest().body(null);
        }
    }
}
