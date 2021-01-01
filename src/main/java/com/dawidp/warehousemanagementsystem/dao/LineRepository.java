package com.dawidp.warehousemanagementsystem.dao;

import com.dawidp.warehousemanagementsystem.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<OrderLine, Long> {

    OrderLine findOrderLineByOrderLineId(Long id);

    OrderLine deleteOrderLineByOrderLineId(Long id);
}
