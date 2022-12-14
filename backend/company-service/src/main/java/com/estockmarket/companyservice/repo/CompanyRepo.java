package com.estockmarket.companyservice.repo;

import com.estockmarket.companyservice.entity.Company;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends MongoRepository<Company, String> {
    
}
