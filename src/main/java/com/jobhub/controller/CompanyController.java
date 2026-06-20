package com.jobhub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.jobhub.entity.Company;
import com.jobhub.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(
            CompanyService companyService) {

        this.companyService = companyService;
    }

    @PostMapping
    public Company createCompany(
            @RequestBody Company company) {

        return companyService.createCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {

        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(
            @PathVariable Long id) {

        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public Company updateCompany(
            @PathVariable Long id,
            @RequestBody Company company) {

        return companyService.updateCompany(
                id,
                company);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(
            @PathVariable Long id) {

        companyService.deleteCompany(id);

        return "Company deleted successfully";
    }
}