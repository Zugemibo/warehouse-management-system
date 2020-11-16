package com.dawidp.warehousemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Measurement implements Serializable {
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
    @JsonBackReference
    private Product product;

    public Measurement(Long measurementId) {
        this.measurementId = measurementId;
        this.unit = Unit.pcs;
    }
}
