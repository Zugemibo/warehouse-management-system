package com.dawidp.warehousemanagementsystem.operations;

import com.dawidp.warehousemanagementsystem.model.OrderLine;
import com.dawidp.warehousemanagementsystem.model.Stock;
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
    @OneToOne
    private OrderLine orderLine;
    @OneToOne
    private Stock stock;
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderPick orderPick;
    @Enumerated
    private LineStatus lineStatus;
    private double quantity;

    public PickLine(OrderLine orderLine, Stock stock) {
        this.stock = stock;
        this.orderLine = orderLine;
        this.quantity = orderLine.getQuantity();

    }
}
