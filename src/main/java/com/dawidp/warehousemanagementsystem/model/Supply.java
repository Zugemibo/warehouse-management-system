package com.dawidp.warehousemanagementsystem.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_id", nullable = false)
	private int supplyId;
	private String supplyNumber;
	@OneToMany(mappedBy = "supply", cascade = CascadeType.ALL)
	private List<SupplyItem> supplyItem;
	@ManyToOne
	@JoinColumn(name = "supplierId")
	private Supplier supplier;
	@CreationTimestamp
	private LocalDateTime added;
	
	public void addItem(SupplyItem item) {
		supplyItem.add(item);
		item.setSupply(this);
	}
	public void removeItem(SupplyItem item) {
		supplyItem.remove(item);
		item.setSupply(null);
	}


}
