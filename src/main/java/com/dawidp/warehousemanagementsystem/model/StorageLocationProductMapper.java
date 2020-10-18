package com.dawidp.warehousemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JoinColumn(name = "palette_barcode")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Palette palette;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_barcode")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;
    private int quantity;
}
