package com.dawidp.warehousemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StorageLocationProductMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_id")
    private Long storageId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_barcode", referencedColumnName = "product_barcode")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_available", referencedColumnName = "stock_available")
    private Stock stock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "space_barcode", referencedColumnName = "space_barcode")
    private PaletteSpace space;

    public StorageLocationProductMapper(Product product, Stock stock, PaletteSpace space) {
        this.product = product;
        this.stock = stock;
        this.space = space;
    }
}
