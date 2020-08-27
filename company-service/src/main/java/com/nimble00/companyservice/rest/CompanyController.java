package com.nimble00.companyservice.rest;

import com.nimble00.companyservice.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/test")
    public String test() {
        return "company service is working";
    }

    @GetMapping("/listCompanies")
    public ResponseEntity<List> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.FOUND).body(companyService.getAllCompanies());
    }

}
