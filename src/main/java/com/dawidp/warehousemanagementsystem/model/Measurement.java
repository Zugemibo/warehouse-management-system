package com.dawidp.warehousemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Measurement {
    @Id
    @Column(name = "measurement_id")
    private Long measurementId;
    @Column(name = "length")
    private double length;
    @Column(name = "width")
    private double width;
    @Column(name = "height")
    private double height;
    @Column(name = "weight")
    private double weight;
    @Column(name = "unit")
    private Unit unit;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Product product;
}
