package com.estockmarket.stockservice.service;

import com.estockmarket.stockservice.dto.NewStockRequestDTO;
import com.estockmarket.stockservice.dto.StockDTO;

public interface StockService {

    StockDTO addNewStock(String companyCode, NewStockRequestDTO requestDTO);
    
}
