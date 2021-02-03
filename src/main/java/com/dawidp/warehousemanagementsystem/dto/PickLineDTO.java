package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;

@Data
public class PickLineDTO {

    private int stockId;
    private String documentNo;
    private String lineStatus;
    private double quantity;
}
