package com.dawidp.warehousemanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import com.dawidp.warehousemanagementsystem.model.*;
import com.dawidp.warehousemanagementsystem.service.CategoryService;
import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;
import com.dawidp.warehousemanagementsystem.service.StockService;
import com.dawidp.warehousemanagementsystem.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PaletteSpaceService paletteSpaceService;
    @Autowired
    private StockService stockService;

    @PostMapping(value = "/createProduct")
    public Product createProduct(@Valid @RequestBody Product product) {
        productService.save(product);
        Price price = new Price(product.getProductId());
        Measurement measurement = new Measurement(product.getProductId());
//        PaletteSpace arrival = paletteSpaceService.getPaletteSpaceByBarcode("DOSTAWA");
//        Stock stock = new Stock(product, arrival);
        product.addPrice(price);
        product.addMeasurement(measurement);
//        product.addStock(stock);
        productService.save(product);
        return product;
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/getProductByCode/{code}")
    public Product getProductByCode(@PathVariable String code) {
        return productService.getProductByCode(code);
    }

    @GetMapping("/getProducts")
    public List<Product> getProductById() {
        return productService.getProducts();
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }

    @PostMapping("/{productBarcode}/addMeasure")
    public Product addMeasurement(@RequestBody Measurement measurement, @PathVariable String productBarcode){
        Product product = productService.getProductByCode(productBarcode);
        measurement.setMeasurementId(product.getProductId());
        product.addMeasurement(measurement);
        return productService.save(product);
    }
    @PostMapping("/{productBarcode}/addStock/{quantity}")
    public Product addStock(@PathVariable double quantity, @PathVariable String productBarcode){
        Product product = productService.getProductByCode(productBarcode);
        product.setStockArrived(quantity);
        return productService.save(product);
    }
    @PostMapping("/{productBarcode}/addPrice")
    public Product addStock(@RequestBody Price price, @PathVariable String productBarcode){
        Product product = productService.getProductByCode(productBarcode);
        price.setPriceId(product.getProductId());
        product.addPrice(price);
        return productService.save(product);
    }
    @PutMapping("/{productBarcode}/addCategory/{categoryName}")
    public Product addCategory(@PathVariable String productBarcode, @PathVariable String categoryName){
        Category category = categoryService.findCategoryByName(categoryName);
        Product product = productService.getProductByCode(productBarcode);
        product.setCategory(category);
        return productService.save(product);
    }

    @JsonView(Views.Stock.class)
    @GetMapping("/{productBarcode}/getStocks")
    public List<Stock> getProductStocks(@PathVariable String productBarcode){
        return stockService.getProductStocks(productBarcode);
    }
}
