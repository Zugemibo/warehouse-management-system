package com.dawidp.warehousemanagementsystem.dao;

import com.dawidp.warehousemanagementsystem.operations.PickLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickLineRepository extends JpaRepository<PickLine, Long> {
}
