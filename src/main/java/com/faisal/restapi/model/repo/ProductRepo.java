package com.faisal.restapi.model.repo;

import com.faisal.restapi.model.entities.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
    
}
