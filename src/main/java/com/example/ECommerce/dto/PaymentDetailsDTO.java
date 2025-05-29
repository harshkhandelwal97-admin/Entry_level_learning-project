package com.example.ECommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentDetailsDTO {
    private Long  paymentId;
    private String customerName;
    private Double totalPrice;
    private String paymentMethod;
}
