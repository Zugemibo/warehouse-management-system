package com.dawidp.warehousemanagementsystem.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.dawidp.warehousemanagementsystem.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
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
    private Long productId;
    @NotNull(message = "Please provide EAN.")
    @NaturalId
    @Column(name = "product_barcode")
    @JsonView(Views.Normal.class)
    private String barcode;
    @NotNull(message = "Please provide product name.")
    @JsonView(Views.Normal.class)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;
    @JsonView(Views.ProductDetailedView.class)
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Measurement measurement;
    @JsonView(Views.ProductDetailedView.class)
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Stock stock;
    @JsonView(Views.ProductDetailedView.class)
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Price price;
    @JsonView(Views.ProductDetailedView.class)
    private String description;
    @JsonView(Views.ProductDetailedView.class)
    @CreationTimestamp
    private LocalDateTime added;
    @OneToMany
    @Column(name = "storage_places")
    @JoinColumn(name = "palette_barcode")
    private List<StorageLocationProductMapper> storages;


    public void setStockAvailable(double quantity) {
        this.getStock().setStockAvailable(quantity);
    }
    public double getStockAvailable(){
        return this.getStock().getStockAvailable();
    }
    public void setStockArrived(double quantity) {
        this.getStock()
                .setStockArrived(quantity);
    }
    public double getStockArrived(){
        return this.getStock().getStockArrived();
    }

    public double calculateVolume(){
        double volume = this.measurement.getLength()*this.measurement.getWidth()*this.measurement.getHeight();
        return volume;
    }

    public double getWeight(){
        if(this.measurement == null) {
            return 0;
        }
        else return this.measurement.getWeight();
    }

    public void addMeasurement(Measurement measurement){
        this.setMeasurement(measurement);
        measurement.setProduct(this);
    }

    public void addStock(Stock stock){
        this.setStock(stock);
        stock.setProduct(this);
    }

    public void addPrice(Price price) {
        this.setPrice(price);
        price.setProduct(this);
    }
}
