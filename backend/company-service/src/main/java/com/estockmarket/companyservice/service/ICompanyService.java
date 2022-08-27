package com.estockmarket.companyservice.service;

import com.estockmarket.companyservice.dto.CompanyDTO;

public interface ICompanyService {

    CompanyDTO registerNewCompany(CompanyDTO companyModel);
}
