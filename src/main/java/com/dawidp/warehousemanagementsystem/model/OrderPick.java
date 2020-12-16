package com.dawidp.warehousemanagementsystem.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class OrderPick implements Serializable {

    private Long pickId;
    private Order order;
    private OrderDeliveryType type;
    private int orderNumberOfItems;
    private String consignmentNoteNumber;
    private double percentageDone;

    public OrderPick(Order order, String consignmentNoteNumber){
        this.consignmentNoteNumber = consignmentNoteNumber;
        this.orderNumberOfItems = order.getLinesItems().size();
        this.percentageDone = 0;


    }
}
