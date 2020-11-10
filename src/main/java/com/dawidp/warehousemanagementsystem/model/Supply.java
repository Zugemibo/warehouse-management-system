package com.dawidp.warehousemanagementsystem.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supply implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supply_id", nullable = false)
	private Long supplyId;
	@NaturalId
	@Column(name = "supply_number")
	private String supplyNumber;
	@OneToMany(mappedBy = "supply", cascade = CascadeType.ALL)
	private List<SupplyItem> supplyItem;
	@ManyToOne
	@JoinColumn(name = "supplier_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
