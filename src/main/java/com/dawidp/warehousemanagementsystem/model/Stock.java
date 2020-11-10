package com.dawidp.warehousemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock implements Serializable {
    @Id
    @Column(name = "stock_id")
    private Long stockId;
    @Column(name = "stock_available")
    private double stockAvailable;
    @Column(name = "stock_reserved")
    private double stockReserved;
    @Column(name = "stock_arrived")
    private double stockArrived;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonBackReference
    private Product product;

    public Stock(Long stockId) {
        this.stockId = stockId;
    }
}
