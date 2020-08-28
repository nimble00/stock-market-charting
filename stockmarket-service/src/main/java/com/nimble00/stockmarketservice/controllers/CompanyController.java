package com.nimble00.stockmarketservice.controllers;

import com.nimble00.stockmarketservice.shared.CompanyRequest;
import com.nimble00.stockmarketservice.shared.CompanyResponse;
import com.nimble00.stockmarketservice.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/test")
    public String test() {
        return "company service is working";
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getAllCompanies());
    }

    @GetMapping("/{sector}")
    public ResponseEntity<List> getAllCompaniesInSector(@PathVariable String sector) {
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.findAllCompanyBySector(sector));
    }

//    @PostMapping("/turnover")
//    public ResponseEntity<List> getAllCompaniesWithinTurnover(@RequestBody Duration duration) {
//        List<CompanyDTO> list = companyService.findCompanyByTurnoverIsWithin(Long.valueOf(duration.from), Long.valueOf(duration.to));
//        return ResponseEntity.status(HttpStatus.FOUND).body(list);
//    }

    @GetMapping("/ticker/{ticker}")
    public ResponseEntity<CompanyResponse> getCompanyByTicker(@PathVariable String ticker) {
        CompanyResponse companyDTO = companyService.findByTickListContaining(ticker);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CompanyResponse> getCompanyByName(@PathVariable String name) {
        CompanyResponse companyDTO = companyService.findByCompanyName(name);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }

    @PostMapping("/updateInfo/{companyId}")
    public ResponseEntity<CompanyResponse> updateCompanyInfo(@RequestBody CompanyRequest companyDTO, @PathVariable Integer companyId) {
        CompanyResponse companyDTO1 = companyService.updateCompany(companyDTO, companyId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyDTO1);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<CompanyResponse> addNewCompany(@RequestBody CompanyRequest companyDTO) throws IOException {
        CompanyResponse companyDTO1 = companyService.createCompany(companyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDTO1);
    }

    @GetMapping("/allInStockExchange/{stockExchange}")
    public ResponseEntity<List> getCompanyByStockExchange(@PathVariable String stockExchange) {
        List<CompanyResponse> list = companyService.findAllByExchangeListContaining(stockExchange);
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Integer id) {
        CompanyResponse companyDTO = companyService.findByCompanyId(id);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }
}

// Test objects for Postman
//{
//        "name": "tesla",
//        "turnover": 100000,
//        "ceo": "daddy musk",
//        "boardOfDirs": "[some old dudes,more old dudes]",
//        "stockExchangeList": ["NYSE"],
//        "sector": "tech",
//        "briefWriteup": "bullish",
//        "tickerList": ["TSLA"]
//}

//{
//        "name": "amazon",
//        "turnover": 9999999999,
//        "ceo": "uncle bejos",
//        "boardOfDirs": "[some old dudes]",
//        "stockExchangeList": ["NYSE","NASDAQ"],
//        "sector": "tech",
//        "briefWriteup": "bullish",
//        "tickerList": ["AMZN","AZN"]
//}