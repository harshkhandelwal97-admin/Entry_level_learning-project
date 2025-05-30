package com.example.ECommerce.controllers;

import com.example.ECommerce.dto.PaymentRequest;
import com.example.ECommerce.entities.Payment;
import com.example.ECommerce.entities.Payments;
import com.example.ECommerce.repositories.PaymentRepository;
import com.example.ECommerce.repositories.PaymentsRepository;
import com.example.ECommerce.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentsRepository paymentRepository;

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

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return ResponseEntity.ok(payments);
    }

    @PostMapping("/add")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(savedPayment);
    }
}
