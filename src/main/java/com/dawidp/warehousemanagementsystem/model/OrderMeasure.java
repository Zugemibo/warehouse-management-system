package com.dawidp.warehousemanagementsystem.model;

public class OrderMeasure {

    public int calculateVolume(Order order){
        int volume = 0;
        for(OrderLine line:order.getLinesItems()){
            volume += (line.calculateVolume());
        }
        return volume;
    }
    public double calculateWeight(Order order){
        double weight = 0;
        for(OrderLine line:order.getLinesItems()){
            weight += (line.getWeight());
        }
        return weight;
    }
}
