package com.example.ECommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "carts")
@Getter
@Setter
@Data
public class Cart {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

     @OneToOne
     @JoinColumn(name="userId")
    private User user;

    private double price;
}
