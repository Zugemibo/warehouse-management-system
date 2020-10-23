package com.dawidp.warehousemanagementsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="paletteId")
public class SinglePaletteSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long singlePaletteSpaceId;
    @NotNull
    private String barcode;
    @OneToOne(mappedBy = "singlePaletteSpace", cascade = CascadeType.ALL)
    private Palette palette;

}
