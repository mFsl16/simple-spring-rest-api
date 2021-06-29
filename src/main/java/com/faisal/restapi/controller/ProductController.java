package com.faisal.restapi.controller;

import com.faisal.restapi.model.entities.Product;
import com.faisal.restapi.services.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Product save(@RequestBody Product product) {
        return productServices.addNewProduct(product);
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
    public Product update(@RequestBody Product product) {
        return productServices.addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productServices.delete(id);
    }
}
