package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.ProductRepository;
import com.dawidp.warehousemanagementsystem.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product getProductById(int id) {
        return repository.findProductByProductId(id);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Product getProductByName(String name) {
        return repository.findProductByName(name);
    }

    public Product getProductByCode(String code) {
        return repository.findProductByBarCode(code);
    }
    /*public void moveProduct(String firstPalette, String productCode, String secondPalette) {
    	
    }
    */
}
