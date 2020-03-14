package com.dawidp.warehousemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class MultiPaletteSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int multiPaletteSpaceId;
    private String barcode;
    private List<Palette> paletteList;

}
