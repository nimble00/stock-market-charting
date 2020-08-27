package com.nimble00.companyservice.dao;

import com.nimble00.companyservice.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends JpaRepository<Company, String> {
    public Company findByName(String name);
    public Company findByTicker(String ticker);
    public List<Company> findAllBySector(String sector);
    public List<Company> findCompanyByTurnoverWithin(Long lo, Long hi);
    public List<Company> findAllByStockExchangeListContaining(String stockExchange);
}
