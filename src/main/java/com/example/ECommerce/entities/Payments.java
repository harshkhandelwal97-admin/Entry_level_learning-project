package com.example.ECommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User customer_id;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    private Double totalAmount;
    private String paymentMethod;

    public void setUser(User user) {
        this.customer_id = user;
    }
}
