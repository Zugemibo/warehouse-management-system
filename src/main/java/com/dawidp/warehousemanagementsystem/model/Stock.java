package com.dawidp.warehousemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long stockId;
    @Column(name = "stock_available")
    private double stockAvailable;
    @Column(name = "stock_reserved")
    private double stockReserved;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", referencedColumnName = "product_barcode")
    @EqualsAndHashCode.Exclude
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space", referencedColumnName = "space_barcode")
    @EqualsAndHashCode.Exclude
    private PaletteSpace space;

    public Stock(Long stockId) {
        this.stockId = stockId;
    }

    public Stock(double stock,Product product, PaletteSpace space) {
        this.stockAvailable = stock;
        product.addStock(this);
        space.addStock(this);
    }
}
