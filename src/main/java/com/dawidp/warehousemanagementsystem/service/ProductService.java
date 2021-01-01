package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.ProductRepository;
import com.dawidp.warehousemanagementsystem.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product save(Product product) {
        product.setAdded(LocalDateTime.now());
        return repository.save(product);
    }

    public Product getProductById(Long id) {
        return repository.findProductByProductId(id);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Product getProductByName(String name) {
        return repository.findProductByName(name);
    }

    public Product getProductByCode(String code) {
        return repository.findProductByProductBarcode(code);
    }
}
