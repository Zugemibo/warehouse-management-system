package com.dawidp.warehousemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock {
    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;
    @Column(name = "stock_available")
    private double stockAvailable;
    @Column(name = "stock_reserved")
    private double stockReserved;
    @Column(name = "stock_arrived")
    private double stockArrived;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "product_barcode")
    private Product product;
    @OneToMany(mappedBy = "stock")
    private Set<StorageLocationProductMapper> storages;

    public Stock(Long stockId) {
        this.stockId = stockId;
    }
    public Stock(Product product ,double stockAvailable) {
        this.product = product;
        this.stockAvailable = stockAvailable;
    }
}
