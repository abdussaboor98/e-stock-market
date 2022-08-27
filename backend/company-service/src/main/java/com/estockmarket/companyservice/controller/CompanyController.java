package com.estockmarket.companyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.companyservice.dto.CompanyDTO;
import com.estockmarket.companyservice.service.CompanyService;


@RestController
@RequestMapping("/api/v1.0/market/company/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @PostMapping(value="test")
    public ResponseEntity<CompanyDTO> postMethodName(@RequestBody CompanyDTO companyDto) {
        CompanyDTO newCompanyDTO = companyService.registerNewCompany(companyDto);
        return new ResponseEntity<>(newCompanyDTO, HttpStatus.CREATED);
    }
    
}
