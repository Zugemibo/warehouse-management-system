package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.OrderPickRepository;
import com.dawidp.warehousemanagementsystem.operations.OrderPick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPickService {

    @Autowired
    private OrderPickRepository orderPickRepository;

    public OrderPick save(OrderPick orderPick) {
        return orderPickRepository.save(orderPick);
    }
}
