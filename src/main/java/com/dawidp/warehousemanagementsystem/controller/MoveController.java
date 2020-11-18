package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.ProductMovement;
import com.dawidp.warehousemanagementsystem.model.Stock;
import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import com.dawidp.warehousemanagementsystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/move")
public class MoveController {

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PaletteSpaceService spaceService;

    @PostMapping("/unitMove")
    public String moveOneProduct(@RequestBody ProductMovement productMovement){
        stockService.getStock(productMovement.getSpaceFrom(), productMovement.getProductBarcode());
        return null;
    }
    @GetMapping("/getStock/{spaceWhere}/{product}")//helper
    public Stock getStock(@PathVariable String spaceWhere, @PathVariable String product){
        Stock stock = stockService.getStock(spaceWhere, product);
        return stock;
    }
}
