package com.dawidp.warehousemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Price implements Serializable {
    @Id
    @Column(name = "price_id")
    private Long priceId;
    @Column(name = "buy_price")
    private double buyPrice;
    @Column(name = "retail_price")
    private double retailPrice;
    @Column(name = "wholesale_price")
    private double wholesalePrice;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonBackReference
    private Product product;

    public Price(Long priceId) {
        this.priceId = priceId;
    }
}
