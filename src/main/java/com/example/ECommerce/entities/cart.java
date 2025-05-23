package com.example.ECommerce.entities;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name= "carts")
@Getter
@Setter
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private double price;
}
