package com.faisal.restapi.model.repo;

import com.faisal.restapi.model.entities.Supplier;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
    
}
