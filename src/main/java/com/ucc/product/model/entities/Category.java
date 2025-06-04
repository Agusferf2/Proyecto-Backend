package com.ucc.product.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  Boolean status;

    //UNA CATEGORIA CON MUCHOS PRODUCTOS
//    @OneToMany(mappedBy = "category")
//    @JsonManagedReference
//    private List<Product> products;
}
