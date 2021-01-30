package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;

@Data
public class StockDTO {
    private String productBarcode;
    private String spaceBarcode;
    private double stockAvailable;
}
