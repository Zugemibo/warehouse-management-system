package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService service;

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());

    @PostMapping("/createProduct")
    public Product createProduct(@Valid @RequestBody Product product) {
        product.setAdded(formatter.format(date));
        return service.save(product);
    }
    @GetMapping("/getProductById/${id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/getProducts")
    public List<Product> getProductById(){
        return service.getProducts();
    }
    @PutMapping("/updateProduct")
    public Product updateProduct(@Valid @RequestBody Product product){
        return service.save(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id){
        service.delete(id);
    }
}
