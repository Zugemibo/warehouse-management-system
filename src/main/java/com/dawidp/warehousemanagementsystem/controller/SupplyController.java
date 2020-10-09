package com.dawidp.warehousemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.domain.NewSupply;
import com.dawidp.warehousemanagementsystem.domain.NewSupplyItem;
import com.dawidp.warehousemanagementsystem.service.SupplyService;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

	@Autowired
	SupplyService service;

	@PostMapping("/addSupply")
	public NewSupply addSupply() {
		return service.save(new NewSupply());
	}

	@PutMapping("/supply")
	public NewSupply changeSupply(@RequestBody NewSupply newSupply) {
		return service.save(newSupply);
	}

	@GetMapping("/supply/{supplyId}")
	public NewSupply getSupply(@PathVariable int supplyId) {
		return service.findNewSupplyBySupplyId(supplyId);
	}

	@DeleteMapping("/supply/{supplyId}")
	public void deleteSupply(@PathVariable int supplyId) {
		service.deleteById(supplyId);
	}

	@PostMapping("/supply/{supplyId}/line/")
	public NewSupply addSupply(@PathVariable int supplyId, @RequestBody NewSupplyItem item) {
		NewSupply supply = service.findNewSupplyBySupplyId(supplyId);
		supply.addItem(item);
		return service.save(supply);
	}
	/*
	 * @PostMapping("/addSupplier") public Supplier addSupplier(@RequestBody
	 * Supplier supplier) { return service.saveSupplier(supplier); }
	 */

}
