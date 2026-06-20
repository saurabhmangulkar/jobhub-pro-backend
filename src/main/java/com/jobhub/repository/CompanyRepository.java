package com.jobhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobhub.entity.Company;

public interface CompanyRepository
        extends JpaRepository<Company, Long> {

}