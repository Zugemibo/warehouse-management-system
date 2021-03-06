package com.dawidp.warehousemanagementsystem.model;

import com.dawidp.warehousemanagementsystem.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Product.class)
    private Long productId;
    @NotNull(message = "Please provide EAN.")
    @NaturalId
    @Column(name = "product_barcode")
    @JsonView({Views.Stock.class, Views.Product.class})
    private String productBarcode;
    @NotNull(message = "Please provide product name.")
    @NaturalId
    @JsonView(Views.Product.class)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_name", referencedColumnName = "category_name")
//    @EqualsAndHashCode.Exclude
//    @JsonView(Views.Product.class)
    private Category category;
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonView(Views.Product.class)
    private Measurement measurement;
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Stock> stocks = new HashSet<>();
    @Column(name = "stock_arrived")
    private double stockArrived;
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Price price;
    @JsonView(Views.Product.class)
    private String description;
    @CreationTimestamp
    private LocalDateTime added;

    @Transient
    public double getTotalStockAvailable(Set<Stock> stocks) {
        double quantity = 0;
        for (Stock stock : stocks) {
            quantity = +stock.getStockAvailable();
        }
        return quantity;
    }

    public double calculateVolume() {
        double volume = this.measurement.getLength() * this.measurement.getWidth() * this.measurement.getHeight();
        return volume;
    }

    @Transient
    public double getWeight() {
        if (this.measurement == null) {
            return 0;
        } else return this.measurement.getWeight();
    }


    public void addMeasurement(Measurement measurement) {
        this.setMeasurement(measurement);
        measurement.setProduct(this);
    }

    public void addPrice(Price price) {
        this.setPrice(price);
        price.setProduct(this);
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
        stock.setProduct(this);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
        stock.setProduct(null);
    }

    public void setStockArrived(double arrived) {
        this.stockArrived = this.stockArrived + arrived;
    }

    public void decreaseStockArrived(double stock) {
        this.stockArrived = this.stockArrived - stock;
    }
}
