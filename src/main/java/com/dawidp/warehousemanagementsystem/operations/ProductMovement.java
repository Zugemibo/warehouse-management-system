package com.dawidp.warehousemanagementsystem.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductMovement {

    private String spaceFrom;
    private String productBarcode;
    private double quantity;
    private String spaceWhere;
}
