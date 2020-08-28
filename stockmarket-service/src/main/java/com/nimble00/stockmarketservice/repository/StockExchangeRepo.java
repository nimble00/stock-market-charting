package com.nimble00.stockmarketservice.repository;

import com.nimble00.stockmarketservice.models.StockExchange;
import com.nimble00.stockmarketservice.models.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepo extends JpaRepository<StockExchange,Integer> {
    public StockExchange findByName(String name);
}
