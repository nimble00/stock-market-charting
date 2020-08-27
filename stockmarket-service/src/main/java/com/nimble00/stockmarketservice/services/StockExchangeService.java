package com.nimble00.stockmarketservice.services;

import com.nimble00.stockmarketservice.shared.StockExchangeDTO;

import java.util.List;

public interface StockExchangeService {
    public StockExchangeDTO createStockExchange(StockExchangeDTO stockExchangeDTO);
    public List<StockExchangeDTO> findAllStockExchanges();
    public StockExchangeDTO findStockExchangeByName(String name);
    public StockExchangeDTO findStockExchangeById(String id);
}
