package com.dawidp.warehousemanagementsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NewSupplyItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_item_id", nullable = false)
	private int supplyItemId;
    @ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	private int amount;
	@ManyToOne
	@JoinColumn(name="supplyId")
	private NewSupply newSupply;
}
