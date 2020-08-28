package com.nimble00.stockmarketservice.services;

import com.nimble00.stockmarketservice.models.StockExchange;
import com.nimble00.stockmarketservice.shared.CompanyRequest;
import com.nimble00.stockmarketservice.shared.CompanyResponse;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    public List<CompanyResponse> getAllCompanies();
    public CompanyResponse createCompany(CompanyRequest companyRequestModel) throws IOException;
    public CompanyResponse updateCompany(CompanyRequest companyRequestModel, Integer id);
    public CompanyResponse findByTickListContaining(String ticker);
    public CompanyResponse findByCompanyName(String name);
    public CompanyResponse findByCompanyId(Integer id);
    public List<CompanyResponse> findAllCompanyBySector(String sector);
//    public List<CompanyDTO> findCompanyByTurnoverIsWithin(Long lo, Long hi);
    public List<CompanyResponse> findAllByExchangeListContaining(String stockExchange);
}
