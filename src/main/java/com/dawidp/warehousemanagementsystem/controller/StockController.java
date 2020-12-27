package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Stock;
import com.dawidp.warehousemanagementsystem.service.StockService;
import com.dawidp.warehousemanagementsystem.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @JsonView(Views.Stock.class)
    @GetMapping("/{productBarcode}")
    public List<Stock> getProductStocks(@PathVariable String productBarcode){
        return stockService.getProductStocks(productBarcode);
    }

}
