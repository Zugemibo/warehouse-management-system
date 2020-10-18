package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Palette;
import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.model.StorageLocationProductMapper;
import com.dawidp.warehousemanagementsystem.service.PaletteService;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import com.dawidp.warehousemanagementsystem.service.StorageLocationProductMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageLocationProductMapperController {

    @Autowired
    private StorageLocationProductMapperService locationService;
    @Autowired
    private PaletteService paletteService;
    @Autowired
    private ProductService productService;

    @PostMapping("/moveFromSupply")
    public String moveFromSupply(@PathVariable String paletteBarcode, @PathVariable String productBarcode, @PathVariable int quantity){
        Palette palette = paletteService.getPalleteByBarcode(paletteBarcode);
        Product product = productService.getProductByCode(productBarcode);
        locationService.save(new StorageLocationProductMapper(palette,product,quantity));
        return "Product with barcode " + product.getBarCode() + " has been moved to " + palette.getPaletteBarcode() + " with quantity " + quantity;
    }
    @GetMapping("/getLocation/{locationId}")
    public StorageLocationProductMapper getLocation(@PathVariable StorageLocationProductMapper locationId){
        return locationService.getLocationById(locationId);
    }
    @GetMapping("/getLocation")
    public List<StorageLocationProductMapper> getStorages(){
        return locationService.findAll();
    }
}
