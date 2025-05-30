package com.example.ECommerce.services;
import com.example.ECommerce.dto.PaymentDetailsDTO;
import com.example.ECommerce.entities.Cart;
import com.example.ECommerce.entities.CartItem;
import com.example.ECommerce.entities.Payments;
import com.example.ECommerce.entities.User;
import com.example.ECommerce.repositories.CartItemRepo;
import com.example.ECommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentHistoryService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CartItemRepo cartItemRepo;

    public PaymentDetailsDTO getPaymentDetails(Long paymentId) {
        Payments payment = paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Long payId = payment.getPaymentId();
        User user = payment.getCustomer_id();
        String username = user.getName();
        String paymentMethod = payment.getPaymentMethod();
        Cart cart = payment.getCart();
        List<CartItem> cartItems = cartItemRepo.findByCartId(cart.getCartId()); // Assuming getCartItems() returns List<CartItem>
        Double totalPrice = 0.0;
        for (CartItem item : cartItems) {
            Double itemTotal = item.getProduct().getProductPrice() * item.getQuantity();
            totalPrice += itemTotal;
        }
        return new PaymentDetailsDTO(payId, username, totalPrice, paymentMethod);
    }
}
