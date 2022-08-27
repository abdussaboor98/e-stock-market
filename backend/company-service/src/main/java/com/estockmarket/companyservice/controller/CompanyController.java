package com.estockmarket.companyservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.companyservice.dto.CompanyDTO;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1.0/market/company/")
public class CompanyController {
    
    @PostMapping(value="test")
    public ResponseEntity<CompanyDTO> postMethodName(@RequestBody CompanyDTO model) {

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
    
}
