package com.dawidp.warehousemanagementsystem.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id", nullable = false)
	private int supplierId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "nip_number")
	private String nipNumber;
	private String street;
	private String city;
	@Column(name = "zip_code")
	private String zipCode;
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@OneToMany(mappedBy = "supplier")
	private List<NewSupply> supplyList;

}
