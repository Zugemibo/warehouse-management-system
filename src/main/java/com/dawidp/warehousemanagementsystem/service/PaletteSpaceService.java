package com.dawidp.warehousemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawidp.warehousemanagementsystem.dao.SinglePaletteSpaceRepository;
import com.dawidp.warehousemanagementsystem.domain.SinglePaletteSpace;

@Service
public class PaletteSpaceService {
	
	@Autowired
	SinglePaletteSpaceRepository singleRepository;

	public void save(SinglePaletteSpace paletteSpace) {
		singleRepository.save(paletteSpace);
		
	}

	public List<SinglePaletteSpace> findAll() {
		return singleRepository.findAll();
	}

	public SinglePaletteSpace getSinglePaletteSpaceByBarcode(String barcode) {
		return singleRepository.getSinglePaletteSpaceByBarcode(barcode);
	}

}
