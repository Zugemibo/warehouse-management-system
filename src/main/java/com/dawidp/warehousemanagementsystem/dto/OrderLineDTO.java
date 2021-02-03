package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;


@Data
public class OrderLineDTO {

    private String productBarcode;
    private double quantity;
}
