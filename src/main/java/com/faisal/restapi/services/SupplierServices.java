package com.faisal.restapi.services;

import java.util.Optional;

import com.faisal.restapi.model.entities.Supplier;
import com.faisal.restapi.model.repo.SupplierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierServices {
    
    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier save(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public Iterable<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    public Supplier findById(Long id){
        Optional<Supplier> temp = supplierRepo.findById(id);

        if(!temp.isPresent()) {
            return null;
        }

        return temp.get();
    }

    public void delete(Long id){
        supplierRepo.deleteById(id);
    }
}
