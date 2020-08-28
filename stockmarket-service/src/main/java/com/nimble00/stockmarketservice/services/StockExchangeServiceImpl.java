package com.nimble00.stockmarketservice.services;

import com.nimble00.stockmarketservice.repository.StockExchangeRepo;
import com.nimble00.stockmarketservice.shared.StockExchangeDTO;
import com.nimble00.stockmarketservice.models.StockExchange;
import com.nimble00.stockmarketservice.services.StockExchangeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class StockExchangeServiceImpl implements StockExchangeService {

    private StockExchangeRepo stockExchangeRepo;
    private ModelMapper modelMapper;

    public StockExchangeServiceImpl(StockExchangeRepo stockExchangeRepo, ModelMapper modelMapper) {
        this.stockExchangeRepo = stockExchangeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public StockExchangeDTO createStockExchange(StockExchangeDTO stockExchangeDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        String exchangeName = stockExchangeDTO.getName();
        StockExchange stockExchange1 = stockExchangeRepo.findByName(exchangeName);
        if (stockExchange1!=null) {
            return modelMapper.map(stockExchange1,StockExchangeDTO.class);
        }
        StockExchange stockExchange = modelMapper.map(stockExchangeDTO, StockExchange.class);
        stockExchangeRepo.save(stockExchange);
        return modelMapper.map(stockExchange, StockExchangeDTO.class);
    }

    @Override
    public List<StockExchangeDTO> findAllStockExchanges() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<StockExchangeDTO>>(){}.getType();
        return modelMapper.map(stockExchangeRepo.findAll(),listType);
    }

    @Override
    public StockExchangeDTO findStockExchangeByName(String name) {
        StockExchange stockExchange = stockExchangeRepo.findByName(name);
        return modelMapper.map(stockExchange,StockExchangeDTO.class);
    }

    @Override
    public StockExchangeDTO findStockExchangeById(Integer id) {
        Optional<StockExchange> optionalStockExchange = stockExchangeRepo.findById(id);
        if (optionalStockExchange.isPresent()) {
            StockExchange stockExchange = optionalStockExchange.get();
            return modelMapper.map(stockExchange,StockExchangeDTO.class);
        }
        // TODO: THROW A NICE EXCEPTION LATER
        return null;
    }
}
