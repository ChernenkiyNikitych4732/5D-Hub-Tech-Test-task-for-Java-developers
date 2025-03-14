package com.chernenkiy.companyservice.service;

import com.chernenkiy.companyservice.dto.CompanyCreateUpdateDto;
import service.company.CompanyDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getAllCompanies();

    CompanyDto findByName(String name);

    CompanyDto createCompany(CompanyCreateUpdateDto dto);

    CompanyDto findByEmployeeId(Long employeeId);

}