package com.dawidp.warehousemanagementsystem.model;

public enum OrderStatus {
    AWAYTING_PAYMENT,
    AWAYTING_SHIPMENT,

    READY_TO_PICK,
    PICKED,
    PACKED,
    COMPLETED,
    SHIPPED,

    CANCELLED,
    DECLINED,
    REFUNDED
}
