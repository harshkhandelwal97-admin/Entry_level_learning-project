package com.example.ECommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class cart_items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_item_id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private cart obj;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    private Long quantity;
}
