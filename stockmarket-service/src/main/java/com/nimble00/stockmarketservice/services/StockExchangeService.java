package com.nimble00.stockmarketservice.services;

import com.nimble00.stockmarketservice.shared.StockExchangeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockExchangeService {
    public StockExchangeDTO createStockExchange(StockExchangeDTO stockExchangeDTO);
    public List<StockExchangeDTO> findAllStockExchanges();
    public StockExchangeDTO findStockExchangeByName(String name);
    public StockExchangeDTO findStockExchangeById(Integer id);
}
