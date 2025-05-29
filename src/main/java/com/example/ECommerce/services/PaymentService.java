package com.example.ECommerce.services;

import com.example.ECommerce.dto.PaymentRequest;
import com.example.ECommerce.entities.Cart;
import com.example.ECommerce.entities.Payments;
import com.example.ECommerce.entities.User;
import com.example.ECommerce.repositories.CartRepo;
import com.example.ECommerce.repositories.PaymentRepository;
import com.example.ECommerce.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepo userRepo;

    public Payments processPayment(PaymentRequest req) {
        Cart cart = cartRepo.findById(req.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        User user = userRepo.findById(req.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Payments payments = new Payments();
        payments.setCart(cart);
        payments.setUser(user);
        payments.setTotalAmount(req.getTotalAmount());
        payments.setPaymentMethod("Phonepe");
        return paymentRepository.save(payments);
    }
}
