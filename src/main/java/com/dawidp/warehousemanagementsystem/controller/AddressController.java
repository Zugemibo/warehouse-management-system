package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Address;
import com.dawidp.warehousemanagementsystem.model.Customer;
import com.dawidp.warehousemanagementsystem.model.Supplier;
import com.dawidp.warehousemanagementsystem.service.CustomerService;
import com.dawidp.warehousemanagementsystem.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/customer/{customerId}")
    public Customer addCustomerAddress(@RequestBody Address address, @PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        customer.setAddress(address);
        customerService.save(customer);
        return customer;
    }

    @PostMapping("/supplier/{supplierId}")
    public Supplier addSupplierAddress(@RequestBody Address address, @PathVariable Long supplierId) {
        Supplier supplier = supplierService.findSupplierById(supplierId);
        supplier.setAddress(address);
        supplierService.saveSupplier(supplier);
        return supplier;
    }
}
