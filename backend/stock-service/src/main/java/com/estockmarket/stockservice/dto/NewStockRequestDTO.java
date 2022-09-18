package com.estockmarket.stockservice.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class NewStockRequestDTO {
    private BigDecimal price;
}
