package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.LineRepository;
import com.dawidp.warehousemanagementsystem.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    @Autowired
    private LineRepository repository;

    public OrderLine getOrderLine(Long id) {
        return repository.findOrderLineByOrderLineId(id);
    }

    public OrderLine save(OrderLine orderLine) {
        return repository.save(orderLine);
    }
}
