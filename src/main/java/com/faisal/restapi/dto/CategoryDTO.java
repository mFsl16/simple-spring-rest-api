package com.faisal.restapi.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {
    
    @NotEmpty(message = "Name can't be emty")
    private String name;
}
