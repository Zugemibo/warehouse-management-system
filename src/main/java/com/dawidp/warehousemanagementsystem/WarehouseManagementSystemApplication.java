package com.dawidp.warehousemanagementsystem;

import com.dawidp.warehousemanagementsystem.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarehouseManagementSystemApplication {

    @Autowired
    private ProductRepository productRepository;

//    @PostConstruct
//    public void initProducts() {
//        List<Product> products = Stream.of(
//                new Product(1,"707-62","Baloon game",200,200,200,1000,300,50,35,"A fine toy", LocalDateTime.now(), null),
//                new Product(2,"707-57","Horse game",200,200,200,1000,300,50,35,"A fine toy", LocalDateTime.now(), null))
//                .collect(Collectors.toList());
//        productRepository.saveAll(products);
//    }

    public static void main(String[] args) {
        SpringApplication.run(WarehouseManagementSystemApplication.class, args);

    }
}
