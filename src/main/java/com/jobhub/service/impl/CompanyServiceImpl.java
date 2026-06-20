package com.jobhub.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobhub.entity.Company;
import com.jobhub.repository.CompanyRepository;
import com.jobhub.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(
            CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company updateCompany(
            Long id,
            Company company) {

        Company existingCompany =
                companyRepository.findById(id).orElse(null);

        if (existingCompany == null) {
            return null;
        }

        existingCompany.setCompanyName(
                company.getCompanyName());

        existingCompany.setDescription(
                company.getDescription());

        existingCompany.setWebsite(
                company.getWebsite());

        existingCompany.setLocation(
                company.getLocation());

        return companyRepository.save(
                existingCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}