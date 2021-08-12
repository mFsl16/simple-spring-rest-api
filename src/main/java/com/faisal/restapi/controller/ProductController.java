package com.faisal.restapi.controller;

import javax.validation.Valid;

import com.faisal.restapi.dto.ResponseDto;
import com.faisal.restapi.model.entities.Product;
import com.faisal.restapi.services.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired ProductServices productServices;
    @PostMapping
    public ResponseEntity<ResponseDto<Product>> save(@Valid @RequestBody Product product, Errors errors) {
        
        ResponseDto<Product> responseDto = new ResponseDto<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseDto.getMessage().add(error.getDefaultMessage());
            }
            responseDto.setStatus(false);
            responseDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }

        responseDto.setStatus(true);
        responseDto.setPayload(productServices.addNewProduct(product));
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping()
    public Iterable<Product> findALl(){
        return productServices.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        return productServices.findOne(id);
    }

    @PutMapping()
    public ResponseEntity<ResponseDto<Product>> update(@Valid @RequestBody Product product, Errors errors) {
        
        ResponseDto<Product> responseDto = new ResponseDto<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseDto.getMessage().add(error.getDefaultMessage());
            }
            responseDto.setStatus(false);
            responseDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }

        responseDto.setStatus(true);
        responseDto.setPayload(productServices.addNewProduct(product));
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productServices.delete(id);
    }
}
