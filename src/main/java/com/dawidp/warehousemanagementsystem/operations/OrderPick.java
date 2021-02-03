package com.dawidp.warehousemanagementsystem.operations;

import com.dawidp.warehousemanagementsystem.model.Order;
import com.dawidp.warehousemanagementsystem.model.OrderDeliveryType;
import com.dawidp.warehousemanagementsystem.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class OrderPick implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pickId;
    @OneToOne
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    private Order order;
    @NaturalId
    private String documentNo;
    @Enumerated(EnumType.STRING)
    private OrderDeliveryType type;
    private int orderNumberOfItems;
    private String consignmentNoteNumber;
    private double percentageDone;
    @OneToMany(
            mappedBy = "orderPick",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PickLine> pickLines = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateStarted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateEnded;

    public OrderPick(Order order) {
        this.orderNumberOfItems = order.getLinesItems().size();
        this.percentageDone = 0;
    }

    public void addLine(PickLine pickline) {
        this.pickLines.add(pickline);
        pickline.setOrderPick(this);
    }

    public void removeLine(PickLine pickLine) {
        this.pickLines.remove(pickLine);
        pickLine.setOrderPick(null);
    }
}
