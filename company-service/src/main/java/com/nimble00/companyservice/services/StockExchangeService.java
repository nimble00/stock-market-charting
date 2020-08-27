package com.nimble00.companyservice.services;

import com.nimble00.companyservice.dtos.StockExchangeDTO;
import com.nimble00.companyservice.models.StockExchange;

import java.util.List;

public interface StockExchangeService {
    public StockExchangeDTO createStockExchange(StockExchangeDTO stockExchangeDTO);
    public List<StockExchangeDTO> findAllStockExchanges();
    public StockExchangeDTO findStockExchangeByName(String name);
    public StockExchangeDTO findStockExchangeById(String id);
}
