package com.ucc.product.model.dto;

import com.ucc.product.model.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO implements Serializable{
    private String name;
    private Double price;
    private CategoryDTO categoryDTO;
}
