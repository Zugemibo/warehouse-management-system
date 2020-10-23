package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.model.OrderLine;

@Repository
public interface LineRepository extends JpaRepository<OrderLine, Long> {

	OrderLine findOrderLineByOrderLineId(Long id);
	OrderLine deleteOrderLineByOrderLineId(Long id);
}
