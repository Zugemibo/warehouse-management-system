package com.dawidp.warehousemanagementsystem.service;

import java.util.Optional;

import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.model.SupplyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawidp.warehousemanagementsystem.dao.SupplyRepository;
import com.dawidp.warehousemanagementsystem.model.Supply;

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
	public Optional<Supply> findSupply(Long supplyId) {
		return repository.findById(supplyId);
	}

}
