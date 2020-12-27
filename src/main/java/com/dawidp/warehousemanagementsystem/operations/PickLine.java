package com.dawidp.warehousemanagementsystem.operations;

import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.operations.OrderPick;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PickLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pickline_id", nullable = false)
    private Long pickLineId;
    @ManyToOne
    @JoinColumn(name = "product_barcode", referencedColumnName = "product_barcode")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    private OrderPick orderPick;
    private Integer quantity;
    @Transient
    private double totalPrice;
}
