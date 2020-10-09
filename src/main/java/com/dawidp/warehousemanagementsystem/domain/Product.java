package com.dawidp.warehousemanagementsystem.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @NotNull(message = "Please provide EAN.")
    @NaturalId
    private String barCode;
    @NotNull(message = "Please provide product name.")
    private String name;
    private int sizeLength;
    private int sizeWidth;
    private int sizeDepth;
    private double weight;
    @NotNull(message = "Please enter an amount.")
    private long stock;
    @NotNull(message = "Please provide retail price.")
    private double priceRetail;
    @NotNull(message = "Please provide wholesale price.")
    private double priceWholeSale;
    private String description;
	@CreationTimestamp
	private LocalDateTime added;
    @ManyToMany(mappedBy = "productList")
    private List<Palette> paletteList;

}
