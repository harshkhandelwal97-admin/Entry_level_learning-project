package com.example.ECommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "carts")
@Getter
@Setter
public class Cart {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long cartId;

     @OneToOne
     @JoinColumn(name="user_id")
    private User user;
}
