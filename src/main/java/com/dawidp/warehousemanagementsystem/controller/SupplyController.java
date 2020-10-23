package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Supplier;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import com.dawidp.warehousemanagementsystem.service.SupplierService;
import com.dawidp.warehousemanagementsystem.service.SupplyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.model.Supply;
import com.dawidp.warehousemanagementsystem.model.SupplyItem;
import com.dawidp.warehousemanagementsystem.service.SupplyService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

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
	public Supply addSupply(@PathVariable Long supplyId, @RequestBody SupplyItem item) {
		Supply supply = supplyService.findSupplyBySupplyId(supplyId);
		item.setProduct(productService.getProductByCode(item.getProduct().getBarCode()));
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

}
