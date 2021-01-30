package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.PickLineRepository;
import com.dawidp.warehousemanagementsystem.operations.PickLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickLineService {

    @Autowired
    private PickLineRepository pickLineRepository;

    public PickLine save(PickLine pickLine) {
        return pickLineRepository.save(pickLine);
    }
}
