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
    private Long productId;
    @NotNull(message = "Please provide EAN.")
    @NaturalId
    @Column(name = "product_barcode")
    private String barCode;
    @NotNull(message = "Please provide product name.")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Measurement measurement;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Stock stock;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Price price;
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
    public void setStockArrived(Long quantity) {
        this.getStock()
                .setStockArrived(this.getStock().getStockArrived() + quantity);
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
