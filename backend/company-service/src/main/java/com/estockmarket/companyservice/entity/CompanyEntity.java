package com.estockmarket.companyservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
public class CompanyEntity {
    @Id
    private String id;
    private String companyCode;
    private String name;
    private String ceoName;
    private Double turnover;
    private String website;
    private String stockExchange;
}
