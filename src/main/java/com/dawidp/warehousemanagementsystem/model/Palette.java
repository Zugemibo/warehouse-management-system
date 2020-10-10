package com.dawidp.warehousemanagementsystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="singlePaletteSpaceId")
public class Palette {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paletteId;
	private String paletteBarcode;
	@ManyToMany
	@JoinTable(name = "palletes_products", joinColumns = @JoinColumn(name = "palette_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> productList;
	@ManyToOne(fetch = FetchType.LAZY)
	private MultiPaletteSpace multiPaletteSpace;
	@OneToOne
	private SinglePaletteSpace singlePaletteSpace;
}
