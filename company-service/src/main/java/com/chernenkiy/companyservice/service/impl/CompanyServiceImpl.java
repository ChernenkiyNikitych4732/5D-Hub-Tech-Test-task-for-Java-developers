package com.chernenkiy.companyservice.service.impl;

import com.chernenkiy.companyservice.dto.CompanyCreateUpdateDto;
import com.chernenkiy.companyservice.entity.CompanyEntity;
import com.chernenkiy.companyservice.mapper.CompanyMapper;
import com.chernenkiy.companyservice.repository.CompanyRepository;
import com.chernenkiy.companyservice.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import service.company.CompanyDto;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .toList();
    }

    @Override
    public CompanyDto findByName(String name) {
        return companyMapper.toDto(companyRepository.findByName(name));
    }

    @Override
    public CompanyDto createCompany(CompanyCreateUpdateDto dto) {
        CompanyEntity userEntity = companyRepository.save(companyMapper.toEntity(dto));

        return companyMapper.toDto(userEntity);
    }

    @Override
    public CompanyDto findByEmployeeId(Long employeeId) {
        CompanyEntity companyEntity = companyRepository.findAll().stream()
                .filter(company -> company.getEmployeesList().contains(employeeId))
                .findFirst()
                .orElse(null);

        if (companyEntity == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");

        return companyMapper.toDto(companyEntity);
    }
}