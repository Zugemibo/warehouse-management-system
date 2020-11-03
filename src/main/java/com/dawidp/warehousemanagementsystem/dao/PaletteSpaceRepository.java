package com.dawidp.warehousemanagementsystem.dao;

import com.dawidp.warehousemanagementsystem.model.PaletteSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaletteSpaceRepository extends JpaRepository<PaletteSpace, Long>{

	PaletteSpace getSinglePaletteSpaceBySpaceBarcode(String barcode);



}
