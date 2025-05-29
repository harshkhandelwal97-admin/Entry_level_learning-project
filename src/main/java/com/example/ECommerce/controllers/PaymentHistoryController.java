package com.example.ECommerce.controllers;

import com.example.ECommerce.dto.PaymentDetailsDTO;
import com.example.ECommerce.services.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentHistoryController {

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDetailsDTO> getPaymentDetails(@PathVariable Long  paymentId) {
        PaymentDetailsDTO paymentDetails = paymentHistoryService.getPaymentDetails(paymentId);
        return ResponseEntity.ok(paymentDetails);
    }
}
