package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.dto.StockDTO;
import com.dawidp.warehousemanagementsystem.model.Stock;
import com.dawidp.warehousemanagementsystem.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private ModelMapper modelMapper;

//    @JsonView(Views.Stock.class)
//    @GetMapping("/{stockBarcode}")
//    public List<Stock> getStockStocks(@PathVariable String stockBarcode) {
//        return stockService.getStockStocks(stockBarcode);
//    }

    @GetMapping("/{productBarcode}")
    public List<StockDTO> getProductStocks(@PathVariable String productBarcode) {
        List<Stock> stocks = stockService.getProductStocks(productBarcode);
        return stocks.stream()
                .map(stock -> convertToDto(stock))
                .collect(Collectors.toList());
    }

    private StockDTO convertToDto(Stock stock) {
        StockDTO stockDTO = modelMapper.map(stock, StockDTO.class);
        return stockDTO;
    }

    private Stock convertToEntity(StockDTO stockDTO) {
        Stock stock = modelMapper.map(stockDTO, Stock.class);
        return stock;
    }

}
