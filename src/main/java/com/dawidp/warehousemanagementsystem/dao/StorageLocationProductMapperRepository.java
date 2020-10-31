package com.dawidp.warehousemanagementsystem.dao;

import com.dawidp.warehousemanagementsystem.model.StorageLocationProductMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageLocationProductMapperRepository extends JpaRepository<StorageLocationProductMapper, Long> {
    StorageLocationProductMapper findStorageLocationProductMapperByStorageId(StorageLocationProductMapper locationId);
}
