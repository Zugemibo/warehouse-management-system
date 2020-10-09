package com.dawidp.warehousemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dawidp.warehousemanagementsystem.domain.Palette;

@Repository
@Transactional
public interface PaletteRepository extends JpaRepository<Palette, Integer> {

	Palette getByPaletteBarcode(String paletteBarcode);

	void deleteByPaletteBarcode(String paletteBarcode);

}
