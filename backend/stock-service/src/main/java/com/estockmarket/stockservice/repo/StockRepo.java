package com.estockmarket.stockservice.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estockmarket.stockservice.entity.Stock;

@Repository
public interface StockRepo extends CrudRepository<Stock, Integer> {
    public List<Stock> findByCompanyCodeAndDateBetweenOrderByDateDescTimeDesc(String companyCode, LocalDate startDate,
            LocalDate endDate);

    public Stock findFirstByCompanyCodeOrderByDateDescTimeDesc(String companyCode);

    public Stock findByCompanyCodeOrderByDateDescTimeDesc(String companyCode);

    @Query("SELECT MAX(price) FROM com.estockmarket.stockservice.entity.Stock WHERE companyCode = ?1 AND date BETWEEN ?2 AND ?3")
    public BigDecimal getMaxStockPriceByCompanyCodeAndDateBetween(String companyCode, LocalDate startDate,
            LocalDate endDate);

    @Query("SELECT MIN(price) FROM com.estockmarket.stockservice.entity.Stock WHERE companyCode = ?1 AND date BETWEEN ?2 AND ?3")
    public BigDecimal getMinStockPriceByCompanyCodeAndDateBetween(String companyCode, LocalDate startDate,
            LocalDate endDate);

    @Query("SELECT AVG(price) FROM com.estockmarket.stockservice.entity.Stock WHERE companyCode = ?1 AND date BETWEEN ?2 AND ?3")
    public BigDecimal getAvgStockPriceByCompanyCodeAndDateBetween(String companyCode, LocalDate startDate,
            LocalDate endDate);

    @Query("FROM com.estockmarket.stockservice.entity.Stock "
            + "WHERE (companyCode, date, time) IN (SELECT companyCode, MAX(date), MAX(time) FROM com.estockmarket.stockservice.entity.Stock GROUP BY companyCode) "
            + "ORDER BY companyCode ASC")
    public List<Stock> getLatestStocksForAllCompanies();
}
