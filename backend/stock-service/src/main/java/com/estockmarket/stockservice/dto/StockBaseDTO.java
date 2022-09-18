package com.estockmarket.stockservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class StockBaseDTO {
    private BigDecimal price;
    private LocalDate date;
    private LocalTime time;
}
