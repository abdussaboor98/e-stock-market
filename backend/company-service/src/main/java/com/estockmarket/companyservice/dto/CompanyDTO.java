package com.estockmarket.companyservice.dto;

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
    private Double turnover;
    private String website;
    private String stockExchange;
}
