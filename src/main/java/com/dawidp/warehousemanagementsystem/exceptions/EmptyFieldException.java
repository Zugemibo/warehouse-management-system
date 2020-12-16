package com.dawidp.warehousemanagementsystem.exceptions;

public class EmptyFieldException extends Exception {
    public EmptyFieldException(String errorMessage){
        super(errorMessage);
    }
}
