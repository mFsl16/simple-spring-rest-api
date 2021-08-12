package com.faisal.restapi.controller;

import javax.validation.Valid;

import com.faisal.restapi.dto.ResponseDto;
import com.faisal.restapi.dto.SupplierDTO;
import com.faisal.restapi.services.SupplierServices;
import com.faisal.restapi.model.entities.Supplier;

import org.modelmapper.ModelMapper;
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
@RequestMapping("api/supplier")
public class SupplierController {
    
    @Autowired
    SupplierServices supplierServices;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @PutMapping
    public ResponseEntity<ResponseDto<Supplier>> addNew(@Valid @RequestBody SupplierDTO supplierDTO, Errors errors) {
        
        ResponseDto<Supplier> responseDto = new ResponseDto<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseDto.getMessage().add(error.getDefaultMessage());
            }
            responseDto.setStatus(false);
            responseDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }

        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        responseDto.setStatus(true);
        responseDto.setPayload(supplierServices.save(supplier));
        return ResponseEntity.ok(responseDto);
        
    }

    @GetMapping
    public Iterable<Supplier> getAll() {
        return supplierServices.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Long id) {
        return supplierServices.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        supplierServices.delete(id);
    }
}
