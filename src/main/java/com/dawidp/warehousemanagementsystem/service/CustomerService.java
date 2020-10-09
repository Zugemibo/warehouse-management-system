package com.dawidp.warehousemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawidp.warehousemanagementsystem.dao.CustomerRepository;
import com.dawidp.warehousemanagementsystem.domain.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;

	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	public Customer getCustomer(int customerId) {
		return repository.findCustomerByCustomerId(customerId);
	}

}
