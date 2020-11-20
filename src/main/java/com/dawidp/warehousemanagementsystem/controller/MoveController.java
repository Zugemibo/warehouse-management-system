package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.PaletteSpace;
import com.dawidp.warehousemanagementsystem.model.Product;
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
        Stock stock = stockService.getStock(productMovement.getSpaceFrom(), productMovement.getProductBarcode());
        if(productMovement.getQuantity()<=stock.getStockAvailable()){
            stock.setStockAvailable(stock.getStockAvailable()-productMovement.getQuantity());
            Product product = productService.getProductByCode(productMovement.getProductBarcode());
            PaletteSpace spaceWhere = spaceService.getPaletteSpaceByBarcode(productMovement.getSpaceWhere());
            Stock newStock = new Stock(productMovement.getQuantity(), product, spaceWhere);
            if(stock.getStockAvailable() == 0){
                stockService.deleteStockById(stock.getStockId());
            }
            else stockService.save(stock);
            stockService.save(newStock);
            return "Product with quantity " + productMovement.getQuantity() + " has been moved to " + productMovement.getSpaceWhere();
        }
        else return "There are no such quantity";

    }
    @GetMapping("/getStock/{spaceWhere}/{product}")//helper
    public Stock getStock(@PathVariable String spaceWhere, @PathVariable String product){
        Stock stock = stockService.getStock(spaceWhere, product);
        return stock;
    }
}
