package com.faisal.restapi.model.repo;

import com.faisal.restapi.model.entities.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    
}
