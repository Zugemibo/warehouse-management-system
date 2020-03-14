package com.dawidp.warehousemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class SinglePaletteSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int singlePaletteSpaceId;
    private String barcode;
    private Palette palette;

}
