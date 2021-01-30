package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.CustomerRepository;
import com.dawidp.warehousemanagementsystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findCustomerByCustomerId(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByNick(String nick) {
        return customerRepository.findCustomerByNick(nick);
    }
}
