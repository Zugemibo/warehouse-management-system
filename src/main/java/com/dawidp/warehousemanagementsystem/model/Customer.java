package com.dawidp.warehousemanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_Id", nullable = false)
	private int customerId;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orderList = new ArrayList<Order>();
}
