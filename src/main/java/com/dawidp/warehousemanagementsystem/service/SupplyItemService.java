package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.model.SupplyItem;
import com.dawidp.warehousemanagementsystem.dao.SupplyItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyItemService {

    @Autowired
    private SupplyItemRepository supplyItemRepository;

    public SupplyItem save(SupplyItem item) {
        item.getProduct().setStockArrived(item.getAmount());
        return supplyItemRepository.save(item);
    }
}
