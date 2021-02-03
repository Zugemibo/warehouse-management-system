package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderPickDTO {

    private String orderNumber;
    private String documentNo;
    private String type;
    private int orderNumberOfItems;
    private String consignmentNoteNumber;
    private double percentageDone;
    private List<PickLineDTO> pickLines;
    private String username;
    private String dateStarted;
    private String dateEnded;
}
