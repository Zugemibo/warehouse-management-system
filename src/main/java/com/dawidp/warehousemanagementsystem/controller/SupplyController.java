package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Supplier;
import com.dawidp.warehousemanagementsystem.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.model.NewSupply;
import com.dawidp.warehousemanagementsystem.model.NewSupplyItem;
import com.dawidp.warehousemanagementsystem.service.SupplyService;

import java.util.List;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

	@Autowired
	SupplyService supplyService;
	@Autowired
	SupplierService supplierService;

	@PostMapping("/addSupply")
	public NewSupply addSupply() {
		return supplyService.save(new NewSupply());
	}

	@PutMapping("/supply")
	public NewSupply changeSupply(@RequestBody NewSupply newSupply) {
		return supplyService.save(newSupply);
	}

	@GetMapping("/supply/{supplyId}")
	public NewSupply getSupply(@PathVariable int supplyId) {
		return supplyService.findNewSupplyBySupplyId(supplyId);
	}

	@DeleteMapping("/supply/{supplyId}")
	public void deleteSupply(@PathVariable int supplyId) {
		supplyService.deleteById(supplyId);
	}

	@PostMapping("/supply/{supplyId}/line/")
	public NewSupply addSupply(@PathVariable int supplyId, @RequestBody NewSupplyItem item) {
		NewSupply supply = supplyService.findNewSupplyBySupplyId(supplyId);
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
