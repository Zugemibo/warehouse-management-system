package com.dawidp.warehousemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawidp.warehousemanagementsystem.dao.LineRepository;
import com.dawidp.warehousemanagementsystem.domain.OrderLine;

@Service
public class OrderLineService {
	
	@Autowired
	LineRepository repository;

	public OrderLine getOrderLine(int id) {
		return repository.findOrderLineByOrderLineId(id);
	}

}
