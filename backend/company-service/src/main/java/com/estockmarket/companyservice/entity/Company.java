package com.estockmarket.companyservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Company {
    @Id
    private String id;
    private String companyCode;
    private String name;
    private String ceoName;
    private Double turnover;
    private String website;
    private String stockExchange;
}
