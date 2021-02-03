package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {

    private Long orderId;
    private String orderNumber;
    private String customerId;
    private String orderDate;
    private String status;
    private String username;
    private List<OrderLineDTO> linesItems = new ArrayList<>();

}
