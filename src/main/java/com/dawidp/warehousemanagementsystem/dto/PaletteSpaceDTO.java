package com.dawidp.warehousemanagementsystem.dto;

import lombok.Data;

@Data
public class PaletteSpaceDTO {
    private int alley;
    private int rack;
    private int place;
    private String spaceBarcode;
}
