package com.dawidp.warehousemanagementsystem.dao;

import com.dawidp.warehousemanagementsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(int id);
}
