package com.estockmarket.companyservice.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estockmarket.companyservice.entity.Company;

@Repository
public interface CompanyRepo extends MongoRepository<Company, String> {
    Company findByCompanyCode(String companyCode);

    List<Company> deleteByCompanyCode(String companyCode);
}
