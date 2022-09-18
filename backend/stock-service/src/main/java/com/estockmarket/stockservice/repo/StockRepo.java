package com.estockmarket.stockservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estockmarket.stockservice.entity.Stock;

@Repository
public interface StockRepo extends CrudRepository<Stock, Integer> {
    
}
