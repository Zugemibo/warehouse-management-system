package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dawidp.warehousemanagementsystem.model.Palette;

@Repository
@Transactional
public interface PaletteRepository extends JpaRepository<Palette, Long> {

	Palette getByPaletteBarcode(String paletteBarcode);

	void deleteByPaletteBarcode(String paletteBarcode);

}
