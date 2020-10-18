package com.dawidp.warehousemanagementsystem.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

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
	@Column(name = "palette_barcode")
	@NaturalId
	private String paletteBarcode;
	@ManyToOne(fetch = FetchType.LAZY)
	private MultiPaletteSpace multiPaletteSpace;
	@OneToOne
	private SinglePaletteSpace singlePaletteSpace;
}
