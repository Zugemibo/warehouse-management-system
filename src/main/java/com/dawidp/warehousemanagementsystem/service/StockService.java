package com.dawidp.warehousemanagementsystem.service;

import com.dawidp.warehousemanagementsystem.dao.StockRepository;
import com.dawidp.warehousemanagementsystem.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    public Stock getStock(String spaceFrom, String productBarcode) {
        return stockRepository.getStockBySpaceBarcodeAndProductBarcode(spaceFrom, productBarcode);
    }
}
