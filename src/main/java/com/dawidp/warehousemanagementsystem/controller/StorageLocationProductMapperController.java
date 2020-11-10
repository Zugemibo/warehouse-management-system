package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.PaletteSpace;
import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.model.StorageLocationProductMapper;
import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;
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
    private ProductService productService;
    @Autowired
    private PaletteSpaceService paletteSpaceService;

    @GetMapping("/getLocation/{locationId}")
    public StorageLocationProductMapper getLocation(@PathVariable StorageLocationProductMapper locationId){
        return locationService.getLocationById(locationId);
    }
    @GetMapping("/getLocation")
    public List<StorageLocationProductMapper> getStorages(){
        return locationService.findAll();
    }

    @PostMapping("/moveProductFromArrival/{what}/{quantity}/{where}")
    public String moveProductFromArrival(@PathVariable String what, @PathVariable double quantity, @PathVariable String where){
        Product product = productService.getProductByCode(what);
        PaletteSpace spaceWhere = paletteSpaceService.getPaletteSpaceByBarcode(where);
        if(product.getStockArrived()>=quantity){
            product.setStockArrived(product.getStockArrived()-quantity);
            product.setStockAvailable(product.getStockAvailable()+quantity);
            if(spaceWhere.getStorages().contains(product)){
                StorageLocationProductMapper storage = (StorageLocationProductMapper) spaceWhere.getStorages().stream().filter(s -> s.getProduct().getProductBarcode()==what);
                storage.setQuantity(storage.getQuantity()+quantity);
                locationService.save(storage);
            }
            else {
                StorageLocationProductMapper storage = new StorageLocationProductMapper(product, quantity, spaceWhere);
                locationService.save(storage);
            }
            return "Product with code: " + product.getProductBarcode() + " has been moved to: " + spaceWhere.getBarcode() + " with quantity:" + quantity;
        }
        else return "There are not enough stock.";
    }
}
