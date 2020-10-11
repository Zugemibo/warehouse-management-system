package com.dawidp.warehousemanagementsystem.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SupplyItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_item_id", nullable = false)
	private int supplyItemId;
    @ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	private int amount;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Supply supply;
}
