package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long productId;
    private String name;
    private String productBarcode;
    private String categoryName;
    private String description;
}
