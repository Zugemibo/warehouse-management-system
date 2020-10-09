package com.dawidp.warehousemanagementsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.domain.Palette;
import com.dawidp.warehousemanagementsystem.domain.SinglePaletteSpace;
import com.dawidp.warehousemanagementsystem.service.PaletteService;
import com.dawidp.warehousemanagementsystem.service.PaletteSpaceService;
import com.dawidp.warehousemanagementsystem.util.BarcodeGenerator;

@RestController
@RequestMapping("/api/palette")
public class PaletteController {

	BarcodeGenerator bgen = BarcodeGenerator.getInstance();

	@Autowired
	PaletteService service;
	@Autowired
	PaletteSpaceService spaceService;

	@PostMapping("/createPalette")
	public Palette createPalette() {
		Palette palette = new Palette();
		palette.setPaletteBarcode(bgen.getPalette());
		return service.save(palette);
	}

	@GetMapping("/getPalettes")
	public List<Palette> getPalletes() {
		return service.getPalletes();
	}

	@GetMapping("/getPalette/{paletteBarcode}")
	public Palette getPaletteByBarcode(@PathVariable String paletteBarcode) {
		return service.getPalleteByBarcode(paletteBarcode);
	}

	@DeleteMapping("/deletePalette/{paletteBarcode}")
	public void deletePaletteByBarcode(@PathVariable String paletteBarcode) {
		service.deletePaletteByBarcode(paletteBarcode);
	}

	@PutMapping("/putPalette/{paletteBarcode}")
	public Palette putPalette(@RequestBody Map<String, Object> map, @PathVariable String paletteBarcode) {
		String spaceCode = (String) map.get("singlePaletteSpace");
		SinglePaletteSpace space = spaceService.getSinglePaletteSpaceByBarcode(spaceCode);
		Palette palette = service.getPalleteByBarcode(paletteBarcode);
		palette.setSinglePaletteSpace(space);
		return service.save(palette);
	}
	@PutMapping("/removePalette/{paletteBarcode}")
	public Palette removePalette(@PathVariable String paletteBarcode) {
		Palette palette = service.getPalleteByBarcode(paletteBarcode);
		palette.setSinglePaletteSpace(null);
		return service.save(palette);
	}

}
