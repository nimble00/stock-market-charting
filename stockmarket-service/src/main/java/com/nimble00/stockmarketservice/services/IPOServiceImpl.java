package com.nimble00.stockmarketservice.services;

import com.nimble00.stockmarketservice.models.Company;
import com.nimble00.stockmarketservice.models.IPO;
import com.nimble00.stockmarketservice.repository.CompanyRepo;
import com.nimble00.stockmarketservice.repository.IPORepo;
import com.nimble00.stockmarketservice.repository.StockExchangeRepo;
import com.nimble00.stockmarketservice.shared.CompanyResponse;
import com.nimble00.stockmarketservice.shared.IpoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class IPOServiceImpl implements IPOService {

    private IPORepo ipoRepo;
    private CompanyRepo companyRepo;
    private StockExchangeRepo stockExchangeRepo;
    private ModelMapper modelMapper;

    public IPOServiceImpl(IPORepo ipoRepo, CompanyRepo companyRepo, StockExchangeRepo stockExchangeRepo, ModelMapper modelMapper) {
        this.ipoRepo = ipoRepo;
        this.companyRepo = companyRepo;
        this.stockExchangeRepo = stockExchangeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public IpoDTO addIPO(IpoDTO ipoDTO) {
        Company company = companyRepo.findByName(ipoDTO.getCompanyName());
        IPO ipo = new IPO();
        ipo.setCompanyName(company);
        ipo.setDateTime(ipoDTO.getDateTime());
        ipo.setNumShares(ipoDTO.getNumShares());
        ipo.setRemarks(ipoDTO.getRemarks());
        ipo.setSharePrice(ipoDTO.getSharePrice());
        ipo.setStockExchange(ipoDTO.getStockExchange());
        return ipoDTO;
    }

    @Override
    public List<IpoDTO> getAllIPO() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyResponse>>(){}.getType();
        return modelMapper.map(ipoRepo.findAll(),listType);
    }
}
