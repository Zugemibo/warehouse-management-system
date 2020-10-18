package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.StorageLocationProductMapper;
import com.dawidp.warehousemanagementsystem.service.StorageLocationProductMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageLocationProductMapperController {

    @Autowired
    StorageLocationProductMapperService locationService;

    @PostMapping("/moveFromSupply")
    public String moveFromSupply(@RequestBody StorageLocationProductMapper location){
        locationService.save(location);
        return "Product with barcode " + location.getProduct() + " has been moved to " + location.getPalette() + " with quantity " + location.getQuantity();
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
