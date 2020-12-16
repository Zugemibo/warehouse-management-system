package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.exceptions.NoSuchAmountException;
import com.dawidp.warehousemanagementsystem.model.*;
import com.dawidp.warehousemanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/supply")
public class SupplyController{

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
    private StockService stockService;

    @PostMapping("/addSupply/{companyName}")
    public Supply addSupply(@RequestBody Supply supply, @PathVariable String companyName) {
        Supplier supplier = supplierService.findSupplierByCompanyName(companyName);
        supply.setSupplier(supplier);
        supply.setAdded(LocalDateTime.now());
        return supplyService.save(supply);
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

    @PostMapping("/supply/{supplyNumber}/line/")
    public Supply addSupplyLine(@PathVariable String supplyNumber, @RequestBody SupplyItem item) {
        Supply supply = supplyService.findSupplyBySupplyNumber(supplyNumber);
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
    public Supplier findSupplier(@PathVariable Long id) {
        return supplierService.findSupplierById(id);
    }

    @DeleteMapping("/supplier/{id}")
    public void removeSupplier(@PathVariable Long id) {
        supplierService.removeSupplier(id);
    }

    @GetMapping("/{companyName}/supplies")
    public List<Supply> listSupplierSupplies(@PathVariable String companyName){
        return supplyService.findSupplyBySupplierCompanyName(companyName);
    }

    @PostMapping("/{productBarcode}/{quantity}/{localization}")
    public String moveProductFromSupply(@PathVariable String productBarcode, @PathVariable double quantity, @PathVariable String localization) throws NoSuchAmountException {
        Product product = productService.getProductByCode(productBarcode);
        if(product.getStockArrived()>=quantity) {
            PaletteSpace space = spaceService.getPaletteSpaceByBarcode(localization);
            Stock stock = new Stock(quantity, product, space);
            stockService.save(stock);
            product.decreaseStockArrived(quantity);
            productService.save(product);
            return "Successfully moved to: " + localization;
//        }else return "There is no such quantity";
        }else throw new NoSuchAmountException("There are no such quantity");
    }

}
