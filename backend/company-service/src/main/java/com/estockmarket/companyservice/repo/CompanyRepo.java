package com.estockmarket.companyservice.repo;

import com.estockmarket.companyservice.entity.CompanyEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepo extends MongoRepository<CompanyEntity, String> {
    
}
