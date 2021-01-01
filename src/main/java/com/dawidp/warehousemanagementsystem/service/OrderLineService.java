package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.LineRepository;
import com.dawidp.warehousemanagementsystem.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    @Autowired
    LineRepository repository;

    public OrderLine getOrderLine(Long id) {
        return repository.findOrderLineByOrderLineId(id);
    }

}
