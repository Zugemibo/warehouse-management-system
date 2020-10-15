package com.dawidp.warehousemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.model.Customer;
import com.dawidp.warehousemanagementsystem.service.CustomerService;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return service.save(customer);
	}

	@GetMapping("/getCustomer/{customerId}")
	public Customer getCustomer(@PathVariable Long customerId) {
		return service.getCustomer(customerId);
	}

}
