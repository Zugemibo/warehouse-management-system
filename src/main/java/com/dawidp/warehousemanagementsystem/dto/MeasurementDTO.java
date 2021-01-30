package com.dawidp.warehousemanagementsystem.dto;

import com.dawidp.warehousemanagementsystem.model.Unit;
import lombok.Data;


@Data
public class MeasurementDTO {
    private Long measurementId;
    private double length;
    private double width;
    private double height;
    private double weight;
    private Unit unit;
}
