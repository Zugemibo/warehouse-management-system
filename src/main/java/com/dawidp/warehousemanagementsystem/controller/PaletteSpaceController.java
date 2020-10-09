package com.dawidp.warehousemanagementsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.domain.SinglePaletteSpace;
import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;

@RestController
@RequestMapping("/api/paletteSpace")
public class PaletteSpaceController {

	@Autowired
	PaletteSpaceService service;

	@PostMapping("/create")
	public List<SinglePaletteSpace> createSpace(@RequestBody Map<String, Object> map){
		int alley = (int) map.get("alley");
		int rack =(int) map.get("rack");
		int height =(int) map.get("height");

		String code = null;
		for (int a = 1; a < alley + 1; a++) {
			for (int r = 1; r < rack + 1; r++) {
				for (int h = 1; h < (height*3) + 1; h++) {
					code = (String.format("%03d", a) + "-" + String.format("%03d", r) + "-" + String.format("%03d", h));
					SinglePaletteSpace paletteSpace = new SinglePaletteSpace();
					paletteSpace.setBarcode(code);
					service.save(paletteSpace);
				}
			}
		}
		return service.findAll();
	}
	@GetMapping("/getSinglePaletteSpaceByBarcode/{barcode}")
	public SinglePaletteSpace getSinglePaletteSpaceByBarcode(@PathVariable String barcode) {
		return service.getSinglePaletteSpaceByBarcode(barcode);
	}
	@GetMapping("/getSingleSpaces")
	public List<SinglePaletteSpace> getSingleSpaces() {
		return service.findAll();
	}

	
	
}
