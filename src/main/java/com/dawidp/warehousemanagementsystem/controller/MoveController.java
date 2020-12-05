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

import java.util.Objects;

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
    public String moveOneProduct(@RequestBody ProductMovement movement){
        Stock stockFrom = stockService.getStock(movement.getSpaceFrom(), movement.getProductBarcode());
        if(movement.getQuantity()<=stockFrom.getStockAvailable()){
            stockFrom.decreaseQuantity(movement.getQuantity());
            Product product = productService.getProductByCode(movement.getProductBarcode());
            PaletteSpace spaceWhere = spaceService.getPaletteSpaceByBarcode(movement.getSpaceWhere());
            Stock stockIfExist = stockService.getStock(spaceWhere.getSpaceBarcode(), product.getProductBarcode());
            if(stockFrom.getStockAvailable() == 0){
                stockService.deleteStockById(stockFrom.getStockId());
            }
            else{
                stockService.save(stockFrom);
            }
            if(Objects.nonNull(stockIfExist)){
                stockIfExist.increaseQuantity(movement.getQuantity());
                stockService.save(stockIfExist);
            }
            else{
                Stock newStock = new Stock(movement.getQuantity(), product, spaceWhere);
                stockService.save(newStock);
            }
            return "Product with quantity " + movement.getQuantity() + " has been moved to " + movement.getSpaceWhere();
        }
        else return "There are no such quantity";

    }
    @GetMapping("/getStock/{spaceWhere}/{product}")//helper
    public Stock getStock(@PathVariable String spaceWhere, @PathVariable String product){
        Stock stock = stockService.getStock(spaceWhere, product);
        return stock;
    }
}
