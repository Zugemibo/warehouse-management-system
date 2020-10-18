package com.dawidp.warehousemanagementsystem.model;

import java.time.LocalDateTime;

import javax.persistence.*;
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
    @Column(name = "product_barcode")
    private String barCode;
    @NotNull(message = "Please provide product name.")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_name")
    private Category category;
    private int sizeLength;
    private int sizeWidth;
    private int sizeDepth;
    private int weight;
    @NotNull(message = "Please enter an amount.")
    private long stock;
    @NotNull(message = "Please provide retail price.")
    private double priceRetail;
    @NotNull(message = "Please provide wholesale price.")
    private double priceWholeSale;
    private String description;
	@CreationTimestamp
	private LocalDateTime added;
}
