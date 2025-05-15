package com.ucc.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer stock;
    private Boolean status;

    public Product(Boolean status, Integer stock, String description, Double price, String name, Long id) {
        this.status = status;
        this.stock = stock;
        this.description = description;
        this.price = price;
        this.name = name;
        this.id = id;
    }
}
