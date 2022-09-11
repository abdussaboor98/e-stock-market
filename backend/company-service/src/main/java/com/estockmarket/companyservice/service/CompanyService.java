package com.estockmarket.companyservice.service;

import java.util.List;

import com.estockmarket.companyservice.dto.CompanyDTO;

public interface CompanyService {

    CompanyDTO registerNewCompany(CompanyDTO companyModel);

    List<CompanyDTO> getAllCompanies();

    CompanyDTO getCompany(String companyCode);

    CompanyDTO deleteCompany(String companyCode);
}
