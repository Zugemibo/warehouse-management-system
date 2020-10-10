package com.dawidp.warehousemanagementsystem.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NewSupply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_id", nullable = false)
	private int supplyId;
	private String supplyNumber;
	@OneToMany(mappedBy="newSupply")
	private List<NewSupplyItem> newSupplyItem;
	@ManyToOne
	@JoinColumn(name = "supplierId")
	private Supplier supplier;
	@CreationTimestamp
	private LocalDateTime added;
	
	public void addItem(NewSupplyItem item) {
		newSupplyItem.add(item);
		item.setNewSupply(this);
	}
	public void removeItem(NewSupplyItem item) {
		newSupplyItem.remove(item);
		item.setNewSupply(null);
	}


}
