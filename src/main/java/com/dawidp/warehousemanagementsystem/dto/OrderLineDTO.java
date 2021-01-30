package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;


@Data
public class OrderLineDTO {

    private String productName;
    private String orderNumber;
    private double quantity;
}
