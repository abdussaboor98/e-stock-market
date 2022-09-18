package com.estockmarket.stockservice.service;

import java.time.LocalDate;
import java.util.List;

import com.estockmarket.stockservice.dto.NewStockRequestDTO;
import com.estockmarket.stockservice.dto.StockDTO;
import com.estockmarket.stockservice.dto.StockDetailsDTO;

public interface StockService {

    StockDTO addNewStock(String companyCode, NewStockRequestDTO requestDTO);

    StockDetailsDTO getStockDetails(String companyCode, LocalDate startDate, LocalDate endDate);

    StockDTO getLatestStock(String companyCode);

    List<StockDTO>  getAllCompaniesLatestStock();
    
}
