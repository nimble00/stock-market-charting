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
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.findAllBySector(sector));
    }

//    @PostMapping("/turnover")
//    public ResponseEntity<List> getAllCompaniesWithinTurnover(@RequestBody Duration duration) {
//        List<CompanyDTO> list = companyService.findCompanyByTurnoverIsWithin(Long.valueOf(duration.from), Long.valueOf(duration.to));
//        return ResponseEntity.status(HttpStatus.FOUND).body(list);
//    }

    @GetMapping("/{ticker}")
    public ResponseEntity<CompanyResponse> getCompanyByTicker(@PathVariable String ticker) {
        CompanyResponse companyDTO = companyService.findByTickerListContaining(ticker);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CompanyResponse> getCompanyByName(@PathVariable String name) {
        CompanyResponse companyDTO = companyService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }

    @PatchMapping("/updateInfo")
    public ResponseEntity<CompanyResponse> updateCompanyInfo(@RequestBody CompanyRequest companyDTO) {
        CompanyResponse companyDTO1 = companyService.updateCompany(companyDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyDTO1);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<CompanyResponse> addNewCompany(@RequestBody CompanyRequest companyDTO) throws IOException {
        System.out.println("####################");
        System.out.println(companyDTO.toString());
        System.out.println("####################");
        CompanyResponse companyDTO1 = companyService.createCompany(companyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDTO1);
    }

    @GetMapping("{/{stockExchange}")
    public ResponseEntity<List> getCompanyByStockExchange(@PathVariable String stockExchange) {
        List<CompanyResponse> list = companyService.findAllByStockExchangeListContaining(stockExchange);
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable String id) {
        CompanyResponse companyDTO = companyService.findById(id);
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