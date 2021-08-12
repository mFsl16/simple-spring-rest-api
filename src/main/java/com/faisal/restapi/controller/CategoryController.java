package com.faisal.restapi.controller;

import javax.validation.Valid;

import com.faisal.restapi.dto.CategoryDTO;
import com.faisal.restapi.dto.ResponseDto;

import com.faisal.restapi.model.entities.Category;

import com.faisal.restapi.services.CategoryServices;

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
@RequestMapping("api/category")
public class CategoryController {
    
    @Autowired
    CategoryServices categoryServices;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @PutMapping
    public ResponseEntity<ResponseDto<Category>> create(@Valid @RequestBody CategoryDTO categoryDTO, Errors errors) {

        ResponseDto<Category> responseDto = new ResponseDto<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseDto.getMessage().add(error.getDefaultMessage());
            }
            responseDto.setStatus(false);
            responseDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }

        Category category = modelMapper.map(categoryDTO, Category.class);

        responseDto.setStatus(true);
        responseDto.setPayload(categoryServices.save(category));
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public Iterable<Category> getAll() {
        return categoryServices.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryServices.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryServices.delete(id);
    }
}
