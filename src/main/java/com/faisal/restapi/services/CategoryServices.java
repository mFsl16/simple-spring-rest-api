package com.faisal.restapi.services;

import java.util.Optional;

import com.faisal.restapi.model.entities.Category;
import com.faisal.restapi.model.repo.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServices {
    
    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> temp = categoryRepo.findById(id);
        
        if (!temp.isPresent()) {
            return null;
        }

        return temp.get();
    }

    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
