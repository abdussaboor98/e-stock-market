package com.estockmarket.stockservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.stockservice.dto.NewStockRequestDTO;
import com.estockmarket.stockservice.dto.StockDTO;
import com.estockmarket.stockservice.dto.StockDetailsDTO;
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

    @GetMapping("get/{companyCode}/latest")
    public ResponseEntity<StockDTO> getLatestStock(@PathVariable String companyCode){
        return new ResponseEntity<>(stockService.getLatestStock(companyCode),HttpStatus.OK);
    }

    @GetMapping("get/{companyCode}/{startDate}/{endDate}")
    public ResponseEntity<StockDetailsDTO> getStockDetails(@PathVariable String companyCode, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return new ResponseEntity<>(stockService.getStockDetails(companyCode, startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("getall/latest")
    public ResponseEntity<List<StockDTO>> getAllCompaniesLatestStock(){
        return new ResponseEntity<>(stockService.getAllCompaniesLatestStock(),HttpStatus.OK);
    }
}
