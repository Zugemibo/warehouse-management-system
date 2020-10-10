package com.dawidp.warehousemanagementsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MultiPaletteSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int multiPaletteSpaceId;
    @NotNull
    private String barcode;
    @OneToMany(mappedBy = "multiPaletteSpace", cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private List<Palette> paletteList;

    public void addPalette(Palette palette){
        paletteList.add(palette);
        palette.setMultiPaletteSpace(this);
    }
    public void removePalette(Palette palette){
        paletteList.remove(palette);
        palette.setMultiPaletteSpace(null);
    }

}
