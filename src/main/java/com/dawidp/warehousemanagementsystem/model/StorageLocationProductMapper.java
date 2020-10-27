package com.dawidp.warehousemanagementsystem.model;

import com.dawidp.warehousemanagementsystem.util.Views;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
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
    @Column(name = "storage_location_id")
    private Long storageLocationId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_barcode")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonView(Views.Normal.class)
    private Product product;
    @JsonView(Views.Normal.class)
    private double quantity;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "barcode")
    private PaletteSpace paletteSpace;

    public PaletteSpace getPaletteSpace() {
        return paletteSpace;
    }

    public void setPaletteSpace(PaletteSpace paletteSpace) {
        this.paletteSpace = paletteSpace;
    }

    public Product getProduct(){
        return this.product;
    }

    public StorageLocationProductMapper(Product product, double quantity, PaletteSpace paletteSpace) {
        this.product = product;
        this.quantity = quantity;
        this.paletteSpace = paletteSpace;
    }
}
