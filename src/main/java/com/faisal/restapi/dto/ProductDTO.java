package com.faisal.restapi.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.faisal.restapi.model.entities.Category;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    
    @NotEmpty(message = "Name cant be empty")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin("0.0")
    private Double price;

    @NotNull(message = "Category is required")
    private Category category;
}
