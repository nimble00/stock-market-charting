package com.nimble00.companyservice.dao;

import com.nimble00.companyservice.models.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepo extends JpaRepository<StockExchange,String> {
    
}
