package com.nimble00.stockmarketservice.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimble00.stockmarketservice.repository.CompanyRepo;
import com.nimble00.stockmarketservice.repository.StockExchangeRepo;
import com.nimble00.stockmarketservice.shared.CompanyRequest;
import com.nimble00.stockmarketservice.shared.CompanyResponse;
import com.nimble00.stockmarketservice.models.Company;
import com.nimble00.stockmarketservice.models.StockExchange;
import com.nimble00.stockmarketservice.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepo companyRepo;
    private StockExchangeRepo stockExchangeRepo;
    private ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepo companyRepo, StockExchangeRepo stockExchangeRepo, ModelMapper modelMapper) {
        this.companyRepo = companyRepo;
        this.stockExchangeRepo = stockExchangeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyResponse>>(){}.getType();
        return modelMapper.map(companyRepo.findAll(),listType);
    }

    @Override
    public CompanyResponse createCompany(CompanyRequest companyRequest) throws IOException {
        Company company = new Company();
        String str = UUID.randomUUID().toString();
        company.setId(str);
        company.setBoardOfDirs(companyRequest.getBoardOfDirs());
        company.setBriefWriteup(companyRequest.getBriefWriteup());
        company.setCeo(companyRequest.getCeo());
        company.setName(companyRequest.getName());
        company.setSector(companyRequest.getSector());
        List<StockExchange> listSE = new ArrayList<>();
        List<String> list = companyRequest.getStockExchangeList();
        for (String st: list) {
            listSE.add(stockExchangeRepo.findByName(st));
        }
        company.setStockExchangeList(listSE);
        company.setTickerList(companyRequest.getTickerList());
        company.setTurnover(companyRequest.getTurnover());
        companyRepo.save(company);
        return modelMapper.map(company,CompanyResponse.class);
    }

    @Override
    public CompanyResponse updateCompany(CompanyRequest companyDTO) {
        companyRepo.save(modelMapper.map(companyDTO,Company.class));
        Optional<Company> optionalCompany = companyRepo.findById(companyDTO.getId());
        Company company = optionalCompany.get();
        return modelMapper.map(company,CompanyResponse.class);
    }

    @Override
    public CompanyResponse findByTickerListContaining(String ticker) {
        Company company = companyRepo.findByTickerListContaining(ticker);
        if (company!=null) {
            return modelMapper.map(company, CompanyResponse.class);
        }
        // TODO: THROW A NICE EXCEPTION HERE
        return null;
    }

    @Override
    public CompanyResponse findByName(String name) {
        Company company = companyRepo.findByName(name);
        if (company!=null) {
            return modelMapper.map(company, CompanyResponse.class);
        }
        // TODO: THROW A NICE EXCEPTION HERE
        return null;
    }

    @Override
    public CompanyResponse findById(String id) {
        Optional<Company> optionalCompany = companyRepo.findById(id);
        if (optionalCompany.isPresent()) {
            return modelMapper.map(optionalCompany.get(), CompanyResponse.class);
        }
        // TODO: THROW A NICE EXCEPTION HERE
        return null;
    }

    @Override
    public List<CompanyResponse> findAllBySector(String sector) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyResponse>>(){}.getType();
        return modelMapper.map(companyRepo.findAllBySector(sector),listType);
    }

//    @Override
//    public List<CompanyDTO> findCompanyByTurnoverIsWithin(Long lo, Long hi) {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        Type listType = new TypeToken<List<CompanyDTO>>(){}.getType();
//        return modelMapper.map(companyRepo.findCompanyByTurnoverIsWithin(lo, hi),listType);
//    }

    @Override
    public List<CompanyResponse> findAllByStockExchangeListContaining(String stockExchange) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyResponse>>(){}.getType();
        return modelMapper.map(companyRepo.findAllByStockExchangeListContaining(stockExchange),listType);
    }
}
