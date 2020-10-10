package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findCustomerByCustomerId(int customerId);
}
