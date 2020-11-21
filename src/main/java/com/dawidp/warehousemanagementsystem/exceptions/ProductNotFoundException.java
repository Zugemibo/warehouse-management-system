package com.dawidp.warehousemanagementsystem.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
