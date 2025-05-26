package com.example.ECommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@Setter
@Getter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_item_id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart obj;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    private Long quantity;
}
