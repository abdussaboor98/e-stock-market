package com.estockmarket.stockservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class StockDTO extends StockBaseDTO {
    private String companyCode;
}
