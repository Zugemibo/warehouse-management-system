package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.*;
import com.dawidp.warehousemanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

    @Autowired
    private SupplyService supplyService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplyItemService supplyItemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PaletteSpaceService spaceService;
    @Autowired
    private StorageLocationProductMapperService storageService;

    @PostMapping("/addSupply")
    public Supply addSupply() {
        return supplyService.save(new Supply());
    }

    @PutMapping("/supply")
    public Supply changeSupply(@RequestBody Supply supply) {
        supply.setAdded(LocalDateTime.now());
        return supplyService.save(supply);
    }

    @GetMapping("/supply/{supplyId}")
    public Supply getSupply(@PathVariable Long supplyId) {
        return supplyService.findSupplyBySupplyId(supplyId);
    }

    @DeleteMapping("/supply/{supplyId}")
    public void deleteSupply(@PathVariable Long supplyId) {
        supplyService.deleteById(supplyId);
    }

    @PostMapping("/supply/{supplyId}/line/")
    public Supply addSupplyLine(@PathVariable Long supplyId, @RequestBody SupplyItem item) {
        Supply supply = supplyService.findSupplyBySupplyId(supplyId);
        item.setProduct(productService.getProductByCode(item.getProduct().getProductBarcode()));
        supplyItemService.save(item);
        supply.addItem(item);
        return supplyService.save(supply);
    }

    @PostMapping("/supplier")
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @GetMapping("/suppliers")
    public List<Supplier> listSupplier() {
        return supplierService.getSuppliers();
    }

    @GetMapping("/supplier/{id}")
    public Supplier addSupplier(@PathVariable Long id) {
        return supplierService.findSupplierById(id);
    }

    @DeleteMapping("/supplier/{id}")
    public void removeSupplier(@PathVariable Long id) {
        supplierService.removeSupplier(id);
    }

    @PostMapping("/moveFromSupply/{productBarcode}/{quantity}/{spaceBarcode}")
    public void moveFromSupply(@PathVariable String productBarcode, @PathVariable double quantity, @PathVariable String spaceBarcode){
        Product product = productService.getProductByCode(productBarcode);
        if(product.getStock().getStockArrived()>=quantity){
            product.getStock().setStockArrived(product.getStock().getStockArrived()-quantity);
            product.getStock().setStockAvailable(quantity);
            productService.save(product);
            PaletteSpace space = spaceService.getPaletteSpaceByBarcode(spaceBarcode);
            StorageLocationProductMapper storage = new StorageLocationProductMapper(product, new Stock(product, quantity), space);
            storageService.save(storage);
        }
    }

}
