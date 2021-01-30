package com.dawidp.warehousemanagementsystem.model;

import com.dawidp.warehousemanagementsystem.operations.OrderPick;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @NaturalId
    private String username;
    private String password;
    private boolean enabled = true;
    private UserRole role;
    @Column(name = "user_firstname")
    private String userFirstName;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<OrderPick> userOrders = new HashSet<>();

    public void addOrder(OrderPick orderPick) {
        userOrders.add(orderPick);
        orderPick.setUser(this);
    }

    public void removeOrder(OrderPick orderPick) {
        userOrders.remove(orderPick);
        orderPick.setUser(null);
    }
}
