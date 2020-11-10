package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.StorageLocationProductMapperRepository;
import com.dawidp.warehousemanagementsystem.model.StorageLocationProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageLocationProductMapperService {

    @Autowired
    StorageLocationProductMapperRepository repository;

    public void save(StorageLocationProductMapper location) {
        repository.save(location);
    }

    public StorageLocationProductMapper getLocationById(StorageLocationProductMapper locationId) {
        return repository.findBystorageLocationId(locationId);
    }

    public List<StorageLocationProductMapper> findAll() {
        return repository.findAll();
    }
}
