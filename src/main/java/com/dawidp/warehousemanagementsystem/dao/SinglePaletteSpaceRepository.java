package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawidp.warehousemanagementsystem.domain.SinglePaletteSpace;

@Repository
public interface SinglePaletteSpaceRepository extends JpaRepository<SinglePaletteSpace, Integer>{

	SinglePaletteSpace getSinglePaletteSpaceByBarcode(String barcode);

}
