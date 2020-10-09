package com.dawidp.warehousemanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawidp.warehousemanagementsystem.dao.SupplyRepository;
import com.dawidp.warehousemanagementsystem.domain.NewSupply;

@Service
public class SupplyService {
	
	@Autowired
	SupplyRepository repository;

	public NewSupply save(NewSupply newSupply) {
		return repository.save(newSupply);
	}

	public NewSupply findNewSupplyBySupplyId(int supplyId) {
		return repository.findNewSupplyBySupplyId(supplyId);
	}

	public void deleteById(int supplyId) {
		repository.deleteById(supplyId);
		
	}
	public Optional<NewSupply> findSupply(int supplyId) {
		return repository.findById(supplyId);
	}

}
