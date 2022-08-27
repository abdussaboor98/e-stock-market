package com.estockmarket.companyservice.model;

import lombok.Data;

@Data
public class CompanyModel {
    private String companyCode;
    private String name;
    private String ceoName;
    private Double turnover;
    private String website;
    private String stockExchange;
}
