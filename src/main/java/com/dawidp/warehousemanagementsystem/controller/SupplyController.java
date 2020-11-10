package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.model.Supplier;
import com.dawidp.warehousemanagementsystem.model.Supply;
import com.dawidp.warehousemanagementsystem.model.SupplyItem;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import com.dawidp.warehousemanagementsystem.service.SupplierService;
import com.dawidp.warehousemanagementsystem.service.SupplyItemService;
import com.dawidp.warehousemanagementsystem.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/supply")
public class SupplyController{

    @Autowired
    SupplyService supplyService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    SupplyItemService supplyItemService;
    @Autowired
    ProductService productService;

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

    @PostMapping("/supply/{supplyId}")
    public void persistSupply(@PathVariable Long supplyId) {
		Supply supply = supplyService.findSupplyBySupplyId(supplyId);
		for(SupplyItem item:supply.getSupplyItem()){
			Product product = productService.getProductByCode(item.getProduct().getProductBarcode());
			product.setStockArrived(item.getAmount());
			productService.save(product);
		}
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

}
