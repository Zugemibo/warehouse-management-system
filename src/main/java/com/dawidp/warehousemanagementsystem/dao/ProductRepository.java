package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByProductId(Long id);

    Product findProductByName(String name);

    Product findProductByBarcode(String barcode);
}

