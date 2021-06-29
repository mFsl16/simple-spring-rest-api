package com.faisal.restapi.services;

import java.util.Optional;

import com.faisal.restapi.model.entities.Product;
import com.faisal.restapi.model.repo.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServices {
    
    @Autowired ProductRepo productRepo;

    public Product addNewProduct(Product product) {
        return productRepo.save(product);
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);

        if(!product.isPresent()){
            return null;
        }

        return product.get();
    }

    public void delete(Long id) {
        productRepo.deleteById(id);;
    }
}
