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
    @JsonProperty(value = "product_id")
    private Long productId;

    @JsonProperty(value = "product_name")
    private String productName;

    @JsonProperty(value = "product_price")
    private Double productPrice;

    @JsonProperty(value = "image_url")
    private String imageUrl;

    @JsonProperty(value = "product_description")
    private String productDescription;
}
