package com.estockmarket.stockservice.service.impl;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estockmarket.stockservice.dto.NewStockRequestDTO;
import com.estockmarket.stockservice.dto.StockDTO;
import com.estockmarket.stockservice.entity.Stock;
import com.estockmarket.stockservice.mapper.impl.StockMapper;
import com.estockmarket.stockservice.repo.StockRepo;
import com.estockmarket.stockservice.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public StockDTO addNewStock(String companyCode, NewStockRequestDTO requestDTO) {
        // TODO: Validate company code and price
        Stock stock = new Stock();
        stock.setCompanyCode(companyCode);
        stock.setPrice(requestDTO.getPrice());
        stock.setDateTime(ZonedDateTime.now(ZoneOffset.UTC));

        Stock savedStock = stockRepo.save(stock);
        return stockMapper.convertToDTO(savedStock);
    }
    
}
