package com.dawidp.warehousemanagementsystem.controller;

import java.util.List;
import java.util.Map;

import com.dawidp.warehousemanagementsystem.model.PaletteSpace;
import com.dawidp.warehousemanagementsystem.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;

@RestController
@RequestMapping("/api/paletteSpace")
public class PaletteSpaceController {

	@Autowired
	PaletteSpaceService service;

	@PostMapping("/single/{name}")
	public PaletteSpace createSingleSpace(@PathVariable String name){
		PaletteSpace paletteSpace = new PaletteSpace(0l,null, name);
		return service.saveSingle(paletteSpace);
	}

	@PostMapping("/create")
	public List<PaletteSpace> createSpace(@RequestBody Map<String, Object> map){
		int alley = (int) map.get("alley");
		int rack =(int) map.get("rack");
		int height =(int) map.get("height");

		String code = null;
		for (int a = 1; a < alley + 1; a++) {
			for (int r = 1; r < rack + 1; r++) {
				for (int h = 1; h < (height*3) + 1; h++) {
					code = (String.format("%03d", a) + "-" + String.format("%03d", r) + "-" + String.format("%03d", h));
					PaletteSpace paletteSpace = new PaletteSpace();
					paletteSpace.setBarcode(code);
					service.save(paletteSpace);
				}
			}
		}
		return service.findAll();
	}
	@JsonView(Views.Normal.class)
	@GetMapping("/getPaletteSpaceByBarcode/{barcode}")
	public PaletteSpace getPaletteSpaceByBarcode(@PathVariable String barcode) {
		return service.getPaletteSpaceByBarcode(barcode);
	}
	@GetMapping("/getPaletteSpaces")
	public List<PaletteSpace> getpaletteSpaces() {
		return service.findAll();
	}

	
	
}
