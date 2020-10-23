package com.dawidp.warehousemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawidp.warehousemanagementsystem.dao.OrderRepository;
import com.dawidp.warehousemanagementsystem.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;

	public Order save(Order order) {
		return repository.save(order);
	}

	public Order getOrder(Long orderId) {
		return repository.findOrderByOrderId(orderId);
	}

	public List<Order> getAllOrders() {
		return repository.findAll();
	}

	public void deleteOrderById(Long orderId) {
		repository.deleteById(orderId);;
	}

}
