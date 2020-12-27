package com.dawidp.warehousemanagementsystem.operations;

import com.dawidp.warehousemanagementsystem.model.Order;
import com.dawidp.warehousemanagementsystem.model.OrderDeliveryType;
import com.dawidp.warehousemanagementsystem.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class OrderPick implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pickId;
    @OneToOne
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    private Order order;
    private String orderPickNo;
    @Enumerated(EnumType.STRING)
    private OrderDeliveryType type;
    private int orderNumberOfItems;
    private String consignmentNoteNumber;
    private double percentageDone;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateStarted;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateEnded;

    public OrderPick(Order order){
        this.orderNumberOfItems = order.getLinesItems().size();
        this.percentageDone = 0;


    }
}
