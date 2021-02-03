package com.dawidp.warehousemanagementsystem.model;

import com.dawidp.warehousemanagementsystem.operations.OrderPick;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_date")
    private String orderDate;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OrderPick pick;
    private OrderStatus status;

    private double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> linesItems = new ArrayList<>();

    public Order addLine(OrderLine line) {
        linesItems.add(line);
        line.setOrder(this);
        return this;
    }

    public Order removeLine(OrderLine line) {
        linesItems.remove(line);
        line.setOrder(null);
        return this;
    }

    public Order removeLines() {
        linesItems.clear();
        return this;
    }

}
