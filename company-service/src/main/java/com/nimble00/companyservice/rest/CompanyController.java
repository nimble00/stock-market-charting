package com.nimble00.companyservice.rest;

import com.nimble00.companyservice.services.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/test")
    public String test() {
        return "company service is working";
    }

}
