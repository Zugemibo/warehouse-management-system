package com.dawidp.warehousemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Palette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paletteId;
    private String paletteBarcode;
    @ManyToOne
    private List<Product> products;
    @NotNull(message = "Please provide amount of product.")
    private int quantity;
    private MultiPaletteSpace multiPaletteSpace;
    private SinglePaletteSpace singlePaletteSpace;
}
