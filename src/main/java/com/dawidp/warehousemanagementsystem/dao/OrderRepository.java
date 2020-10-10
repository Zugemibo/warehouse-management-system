package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findOrderByOrderId(int orderId);
}
