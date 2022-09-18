package com.estockmarket.stockservice.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class StockBaseDTO {
    private BigDecimal price;
    private ZonedDateTime dateTime;
}
