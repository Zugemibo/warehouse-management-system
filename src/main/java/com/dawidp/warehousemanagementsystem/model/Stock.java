package com.dawidp.warehousemanagementsystem.model;

import com.dawidp.warehousemanagementsystem.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @JsonView(Views.Stock.class)
    private double stockAvailable;
    @Column(name = "stock_reserved")
    private double stockReserved;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", referencedColumnName = "product_barcode")
    @EqualsAndHashCode.Exclude
    @JsonView(Views.Stock.class)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space", referencedColumnName = "space_barcode")
    @EqualsAndHashCode.Exclude
    @JsonView(Views.Stock.class)
    private PaletteSpace space;

    public Stock(Long stockId) {
        this.stockId = stockId;
    }

    public Stock(double stock, Product product, PaletteSpace space) {
        this.stockAvailable = stock;
        product.addStock(this);
        space.addStock(this);
    }

    public void decreaseQuantity(Double quantity) {
        this.setStockAvailable(this.getStockAvailable() - quantity);
    }

    public void increaseQuantity(Double quantity) {
        this.setStockAvailable(this.getStockAvailable() + quantity);
    }
}
