package com.dawidp.warehousemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @NotNull(message = "Please provide EAN.")
    private int barCode;
    private int sizeLength;
    private int sizeWidth;
    private int sizeDepth;
    private double weight;
    @NotNull(message = "Please enter an amount.")
    private int stock;
    @NotNull(message = "Please provide retail price.")
    private double priceRetail;
    @NotNull(message = "Please provide wholesale price.")
    private double priceWholesale;
    private String description;
    private String added;
    private Palette palette;

}
