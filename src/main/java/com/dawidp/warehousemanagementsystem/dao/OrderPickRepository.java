package com.dawidp.warehousemanagementsystem.dao;

import com.dawidp.warehousemanagementsystem.operations.OrderPick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPickRepository extends JpaRepository<OrderPick, Long> {
}
