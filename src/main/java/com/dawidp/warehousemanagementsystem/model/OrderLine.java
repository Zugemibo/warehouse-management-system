package com.dawidp.warehousemanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class OrderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id", nullable = false)
    private Long orderLineId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private double quantity;
    @Transient
    private double totalPrice;

    @Transient
    public double calculateVolume() {
        return product.calculateVolume();
    }

    @Transient
    public double getWeight() {
        return product.getWeight();
    }
}
