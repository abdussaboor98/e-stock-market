package com.estockmarket.stockservice.service.impl;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estockmarket.stockservice.dto.NewStockRequestDTO;
import com.estockmarket.stockservice.dto.StockDTO;
import com.estockmarket.stockservice.dto.StockDetailsDTO;
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
        ZonedDateTime currentUTCDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        stock.setDate(currentUTCDateTime.toLocalDate());
        stock.setTime(currentUTCDateTime.toLocalTime());
        Stock savedStock = stockRepo.save(stock);
        return stockMapper.convertToDTO(savedStock);
    }

    @Override
    public StockDetailsDTO getStockDetails(String companyCode, LocalDate startDate, LocalDate endDate) {
        // TODO validate company code and the dates
        List<Stock> stockList = stockRepo.findByCompanyCodeAndDateBetweenOrderByDateDescTimeDesc(companyCode, startDate, endDate);
        return StockDetailsDTO.builder().companyCode(companyCode)
                .minPrice(stockRepo.getMinStockPriceByCompanyCodeAndDateBetween(companyCode, startDate, endDate))
                .maxPrice(stockRepo.getMaxStockPriceByCompanyCodeAndDateBetween(companyCode, startDate, endDate))
                .avgPrice(stockRepo.getAvgStockPriceByCompanyCodeAndDateBetween(companyCode, startDate, endDate))
                .stockRecords(stockMapper.convertToBaseDTOList(stockList)).build();
    }

    @Override
    public StockDTO getLatestStock(String companyCode) {
        // TODO Validation and exception for not forund
        return stockMapper.convertToDTO(stockRepo.findFirstByCompanyCodeOrderByDateDescTimeDesc(companyCode));
    }

    @Override
    public List<StockDTO> getAllCompaniesLatestStock() {
        return stockMapper.convertToDTOList(stockRepo.getLatestStocksForAllCompanies());
    }

}
