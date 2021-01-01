package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.SupplyRepository;
import com.dawidp.warehousemanagementsystem.model.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {

    @Autowired
    SupplyRepository repository;

    public Supply save(Supply supply) {
        return repository.save(supply);
    }

    public Supply findSupplyBySupplyId(Long supplyId) {
        return repository.findSupplyBySupplyId(supplyId);
    }

    public void deleteById(Long supplyId) {
        repository.deleteById(supplyId);

    }

    public Supply findSupplyBySupplyNumber(String supplyNumber) {
        return repository.findSupplyBySupplyNumber(supplyNumber);
    }

    public List<Supply> findSupplyBySupplierCompanyName(String companyName) {
        return repository.findSupplyBySupplierCompanyName(companyName);
    }
}
