package com.estockmarket.companyservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private String companyCode;
    private String name;
    private String ceoName;
    private BigDecimal turnover;
    private String website;
    private String stockExchange;
}
