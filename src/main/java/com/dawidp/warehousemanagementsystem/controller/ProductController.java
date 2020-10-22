package com.dawidp.warehousemanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import com.dawidp.warehousemanagementsystem.model.Measurement;
import com.dawidp.warehousemanagementsystem.model.Price;
import com.dawidp.warehousemanagementsystem.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping(value = "/createProduct", produces="application/json")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        service.save(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @GetMapping("/getProductByCode/{code}")
    public Product getProductByCode(@PathVariable String code) {
        return service.getProductByCode(code);
    }

    @GetMapping("/getProducts")
    public List<Product> getProductById() {
        return service.getProducts();
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@Valid @RequestBody Product product) {
        return service.save(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {
        service.delete(id);
    }

    @PostMapping("/{productBarcode}/addMeasurement")
    public Product addMeasurement(@RequestBody Measurement measurement, @PathVariable String productBarcode){
        Product product = service.getProductByCode(productBarcode);
        product.addMeasurement(measurement);
        return service.save(product);
    }
    @PostMapping("/{productBarcode}/addStock")
    public Product addStock(@RequestBody Stock stock, @PathVariable String productBarcode){
        Product product = service.getProductByCode(productBarcode);
        product.addStock(stock);
        return service.save(product);
    }
    @PostMapping("/{productBarcode}/addPrice")
    public Product addStock(@RequestBody Price price, @PathVariable String productBarcode){
        Product product = service.getProductByCode(productBarcode);
        product.addPrice(price);
        return service.save(product);
    }
}
