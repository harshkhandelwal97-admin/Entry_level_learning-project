package com.example.ECommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentRequest {
private Long paymentId;
private Long cartId;
private Long userId;
private Double totalAmount;
private String paymentMethod;
}
