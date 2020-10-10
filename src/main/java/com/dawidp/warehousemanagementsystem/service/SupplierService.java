package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.SupplierRepository;
import com.dawidp.warehousemanagementsystem.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier findSupplierById(Long id) {
        return supplierRepository.findSupplierById(id);
    }

    public void removeSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
