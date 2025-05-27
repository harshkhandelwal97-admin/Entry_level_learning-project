package com.example.ECommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @JsonProperty(value = "product_id")
    private Long productId;

    @Column(name = "product_name")
    @JsonProperty(value = "product_name")
    private String productName;

    @Column(name = "product_price")
    @JsonProperty(value = "product_price")
    private Double productPrice;

    @Column(name = "image_url")
    @JsonProperty(value = "image_url")
    private String imageUrl;

    @Column(name = "product_description")
    @JsonProperty(value = "product_description")
    private String productDescription;
}
