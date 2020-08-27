package com.nimble00.stockmarketservice.services;

import com.nimble00.stockmarketservice.shared.CompanyRequest;
import com.nimble00.stockmarketservice.shared.CompanyResponse;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    public List<CompanyResponse> getAllCompanies();
    public CompanyResponse createCompany(CompanyRequest companyRequestModel) throws IOException;
    public CompanyResponse updateCompany(CompanyRequest companyRequestModel);
    public CompanyResponse findByTickerListContaining(String ticker);
    public CompanyResponse findByName(String name);
    public CompanyResponse findById(String id);
    public List<CompanyResponse> findAllBySector(String sector);
//    public List<CompanyDTO> findCompanyByTurnoverIsWithin(Long lo, Long hi);
    public List<CompanyResponse> findAllByStockExchangeListContaining(String stockExchange);
}
