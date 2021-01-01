package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Customer;
import com.dawidp.warehousemanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
