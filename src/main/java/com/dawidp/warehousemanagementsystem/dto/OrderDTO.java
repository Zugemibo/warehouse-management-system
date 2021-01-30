package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {

    private String customerNick;
    private String orderNumber;
    private String orderDate;
    private List<OrderLineDTO> linesItems = new ArrayList<OrderLineDTO>();

}
