package com.ucc.product.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer stock;
    private Boolean status;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;
//    public Product(Boolean status, Integer stock, String description, Double price, String name, Long id) {
//        this.status = status;
//        this.stock = stock;
//        this.description = description;
//        this.price = price;
//        this.name = name;
//        this.id = id;
//    }
}
