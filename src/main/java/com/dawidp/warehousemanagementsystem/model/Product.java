package com.dawidp.warehousemanagementsystem.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @NotNull(message = "Please provide EAN.")
    @NaturalId
    @Column(name = "product_barcode")
    private String barCode;
    @NotNull(message = "Please provide product name.")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;
    private int sizeLength;
    private int sizeWidth;
    private int sizeDepth;
    private int weight;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private ProductStock stock;
    @NotNull(message = "Please provide price.")
    private double price;
    private String description;
    @CreationTimestamp
    private LocalDateTime added;
    @OneToMany
    @Column(name = "storage_places")
    @JoinColumn(name = "palette_barcode")
    private List<StorageLocationProductMapper> storages;


    public void setStockAvailable(Long quantity) {
        this.getStock().setStockAvailable(quantity);
    }
}
