package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.StorageLocationProductMapper;
import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import com.dawidp.warehousemanagementsystem.service.StorageLocationProductMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public StorageLocationProductMapper getLocation(@PathVariable StorageLocationProductMapper locationId) {
        return locationService.getLocationById(locationId);
    }

    @GetMapping("/getLocation")
    public List<StorageLocationProductMapper> getStorages() {
        return locationService.findAll();
    }

}
