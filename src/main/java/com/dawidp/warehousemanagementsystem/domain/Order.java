package com.dawidp.warehousemanagementsystem.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@Column(name = "order_date")
	private String orderDate;

	private double total;

	@OneToMany(mappedBy = "order", cascade = CascadeType.REFRESH)
	private List<OrderLine> linesItems = new ArrayList<OrderLine>();

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
