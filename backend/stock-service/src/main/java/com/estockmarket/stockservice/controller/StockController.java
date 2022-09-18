package com.estockmarket.stockservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.stockservice.dto.NewStockRequestDTO;
import com.estockmarket.stockservice.dto.StockDTO;
import com.estockmarket.stockservice.service.StockService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/1.0/market/stock/")
public class StockController {
    
    private final StockService stockService;

    @PostMapping("add/{companyCode}")
    public ResponseEntity<StockDTO> addNewStockEntry(@RequestBody NewStockRequestDTO requestDTO, @PathVariable String companyCode) {
        StockDTO newStock = stockService.addNewStock(companyCode, requestDTO);
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
    }
}
