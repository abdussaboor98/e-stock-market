package com.estockmarket.companyservice.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "companies")
public class Company {
    @Id
    private String id;
    @Indexed(unique = true, name = "_company_code")
    private String companyCode;
    private String name;
    private String ceoName;
    private BigDecimal turnover;
    private String website;
    private String stockExchange;
}
