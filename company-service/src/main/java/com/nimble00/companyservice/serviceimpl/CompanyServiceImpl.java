package com.nimble00.companyservice.serviceimpl;

import com.nimble00.companyservice.dao.CompanyRepo;
import com.nimble00.companyservice.dtos.CompanyDTO;
import com.nimble00.companyservice.models.Company;
import com.nimble00.companyservice.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepo companyRepo;
    private ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepo companyRepo, ModelMapper modelMapper) {
        this.companyRepo = companyRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDTO>>(){}.getType();
        return modelMapper.map(companyRepo.findAll(),listType);
    }

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        String str = UUID.randomUUID().toString();
        companyDTO.setId(str);
        companyRepo.save(modelMapper.map(companyDTO, Company.class));
        return companyDTO;
    }

    @Override
    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        companyRepo.save(modelMapper.map(companyDTO,Company.class));
        Optional<Company> optionalCompany = companyRepo.findById(companyDTO.getId());
        Company company = optionalCompany.get();
        return modelMapper.map(company,CompanyDTO.class);
    }

    @Override
    public CompanyDTO findByTicker(String ticker) {
        Company company = companyRepo.findByTicker(ticker);
        if (company!=null) {
            return modelMapper.map(company, CompanyDTO.class);
        }
        // TODO: THROW A NICE EXCEPTION HERE
        return null;
    }

    @Override
    public CompanyDTO findByName(String name) {
        Company company = companyRepo.findByName(name);
        if (company!=null) {
            return modelMapper.map(company, CompanyDTO.class);
        }
        // TODO: THROW A NICE EXCEPTION HERE
        return null;
    }

    @Override
    public CompanyDTO findById(String id) {
        Optional<Company> optionalCompany = companyRepo.findById(id);
        if (optionalCompany.isPresent()) {
            return modelMapper.map(optionalCompany.get(), CompanyDTO.class);
        }
        // TODO: THROW A NICE EXCEPTION HERE
        return null;
    }

    @Override
    public List<Company> findAllBySector(String sector) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDTO>>(){}.getType();
        return modelMapper.map(companyRepo.findAllBySector(sector),listType);
    }

    @Override
    public List<Company> findCompanyByTurnoverWithin(Long lo, Long hi) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDTO>>(){}.getType();
        return modelMapper.map(companyRepo.findCompanyByTurnoverWithin(lo, hi),listType);
    }

    @Override
    public List<Company> findAllByStockExchangeListContaining(String stockExchange) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CompanyDTO>>(){}.getType();
        return modelMapper.map(companyRepo.findAllByStockExchangeListContaining(stockExchange),listType);
    }
}
