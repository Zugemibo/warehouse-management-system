package com.dawidp.warehousemanagementsystem.exceptions;

public class NoSuchAmountException extends Exception {
    public NoSuchAmountException(String errorMessage) {
        super(errorMessage);
    }
}
