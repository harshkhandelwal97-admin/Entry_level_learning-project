package com.example.ECommerce.services;

import com.example.ECommerce.dto.PaymentDetailsDTO;
import com.example.ECommerce.dto.PaymentRequest;
import com.example.ECommerce.dto.ProductDTO;
import com.example.ECommerce.entities.Cart;
import com.example.ECommerce.entities.CartItem;
import com.example.ECommerce.entities.Payments;
import com.example.ECommerce.entities.User;
import com.example.ECommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentHistoryService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDetailsDTO getPaymentDetails(Long paymentId) {
        Payments payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Long payId = payment.getPaymentId();
        User user = payment.getCustomer_id();
        String username = payment.getCustomer_id().getName();
        String paymentMethod = payment.getPaymentMethod();
        Cart cart = payment.getCart();
        Double totalPrice = payment.getCart().getPrice();
        return new PaymentDetailsDTO(payId, username, totalPrice, paymentMethod);


    }
}
