package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.PaletteSpaceRepository;
import com.dawidp.warehousemanagementsystem.model.PaletteSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaletteSpaceService {

    @Autowired
    PaletteSpaceRepository paletteSpaceRepository;

    public void save(PaletteSpace paletteSpace) {
        paletteSpaceRepository.save(paletteSpace);

    }

    public PaletteSpace saveSingle(PaletteSpace paletteSpace) {
        return paletteSpaceRepository.save(paletteSpace);

    }

    public List<PaletteSpace> findAll() {
        return paletteSpaceRepository.findAll();
    }

    public PaletteSpace getPaletteSpaceByBarcode(String barcode) {
        return paletteSpaceRepository.getSinglePaletteSpaceBySpaceBarcode(barcode);
    }

}
