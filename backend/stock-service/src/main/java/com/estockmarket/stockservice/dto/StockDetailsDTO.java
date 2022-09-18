package com.estockmarket.stockservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDetailsDTO {
    private String companyCode;
    private List<StockBaseDTO> stockRecords;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal avgPrice;
}
