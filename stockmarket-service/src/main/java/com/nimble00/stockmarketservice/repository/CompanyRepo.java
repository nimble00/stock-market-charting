package com.nimble00.stockmarketservice.repository;

import com.nimble00.stockmarketservice.models.Company;
import com.nimble00.stockmarketservice.models.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {
    public Company findByName(String name);
    public Company findByTickerListContaining(String ticker);
    public List<Company> findAllBySector(String sector);
//    public List<Company> findCompanyByTurnoverIsWithin(Long lo, Long hi);
    public List<Company> findAllByStockExchangeListContaining(StockExchange stockExchange);
}
