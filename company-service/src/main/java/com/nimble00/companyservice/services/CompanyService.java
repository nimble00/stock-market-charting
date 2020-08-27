package com.nimble00.companyservice.services;

import com.nimble00.companyservice.dtos.CompanyDTO;
import com.nimble00.companyservice.models.Company;

import java.util.List;

public interface CompanyService {
    public List<CompanyDTO> getAllCompanies();
    public CompanyDTO createCompany(CompanyDTO companyDTO);
    public CompanyDTO updateCompany(CompanyDTO companyDTO);
    public CompanyDTO findByTicker(String ticker);
    public CompanyDTO findByName(String name);
    public CompanyDTO findById(String id);
    public List<Company> findAllBySector(String sector);
    public List<Company> findCompanyByTurnoverWithin(Long lo, Long hi);
    public List<Company> findAllByStockExchangeListContaining(String stockExchange);
}
