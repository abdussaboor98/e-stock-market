package com.estockmarket.companyservice.service.impl;

import org.springframework.stereotype.Service;

import com.estockmarket.companyservice.dto.CompanyDTO;
import com.estockmarket.companyservice.repo.CompanyRepo;
import com.estockmarket.companyservice.service.ICompanyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private CompanyRepo companyRepo;

    @Override
    public CompanyDTO registerNewCompany(CompanyDTO companyModel) {
        
        return null;
    }

    
}