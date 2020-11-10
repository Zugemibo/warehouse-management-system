package com.dawidp.warehousemanagementsystem.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SupplyItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_item_id", nullable = false)
	private Long supplyItemId;
    @OneToOne
    @JoinColumn(name = "product_barcode", referencedColumnName = "product_barcode")
	private Product product;
	private double amount;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supply_number", referencedColumnName = "supply_number")
	private Supply supply;
}
