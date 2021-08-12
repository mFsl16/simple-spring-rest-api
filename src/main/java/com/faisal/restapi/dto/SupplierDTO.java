package com.faisal.restapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class SupplierDTO {
    
    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "Address can't be empty")
    private String address;
}
