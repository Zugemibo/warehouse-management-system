package com.dawidp.warehousemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock {
    @Id
    @Column(name = "stock_id")
    private Long stockId;
    @NaturalId
    @Column(name = "stock_available")
    private Long stockAvailable;
    @Column(name = "stock_reserved")
    private Long stockReserved;
    @Column(name = "stock_arrived")
    private Long stockArrived;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Product product;
}
