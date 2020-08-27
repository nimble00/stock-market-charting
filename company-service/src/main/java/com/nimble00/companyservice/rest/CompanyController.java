package com.nimble00.companyservice.rest;

import com.nimble00.companyservice.dtos.CompanyDTO;
import com.nimble00.companyservice.dtos.Duration;
import com.nimble00.companyservice.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

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

    @PostMapping("/turnover")
    public ResponseEntity<List> getAllCompaniesWithinTurnover(@RequestBody Duration duration) {
        List<CompanyDTO> list = companyService.findCompanyByTurnoverWithin(Long.valueOf(duration.from), Long.valueOf(duration.to));
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    @GetMapping("/{ticker}")
    public ResponseEntity<CompanyDTO> getCompanyByTicker(@PathVariable String ticker) {
        CompanyDTO companyDTO = companyService.findByTicker(ticker);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CompanyDTO> getCompanyByName(@PathVariable String name) {
        CompanyDTO companyDTO = companyService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }

    @PatchMapping("/updateInfo")
    public ResponseEntity<CompanyDTO> updateCompanyInfo(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO companyDTO1 = companyService.updateCompany(companyDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyDTO1);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<CompanyDTO> addNewCompany(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO companyDTO1 = companyService.createCompany(companyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDTO1);
    }

    @GetMapping("{/{stockExchange}")
    public ResponseEntity<List> getCompanyByStockExchange(@PathVariable String stockExchange) {
        List<CompanyDTO> list = companyService.findAllByStockExchangeListContaining(stockExchange);
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable String id) {
        CompanyDTO companyDTO = companyService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(companyDTO);
    }
}
