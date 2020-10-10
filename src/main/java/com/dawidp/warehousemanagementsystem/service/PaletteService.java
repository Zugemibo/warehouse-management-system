package com.dawidp.warehousemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawidp.warehousemanagementsystem.dao.PaletteRepository;
import com.dawidp.warehousemanagementsystem.model.Palette;

@Service
public class PaletteService {

	
	@Autowired
	PaletteRepository repository;

	public Palette save(Palette palette) {
		return repository.save(palette);
	}

	public List<Palette> getPalletes() {
		return repository.findAll();
	}

	public Palette getPalleteByBarcode(String paletteBarcode) {
		return repository.getByPaletteBarcode(paletteBarcode);
	}

	public void deletePaletteByBarcode(String paletteBarcode) {
		repository.deleteByPaletteBarcode(paletteBarcode);
		
	}
	
}
