package com.chernenkiy.companyservice.controller;

import com.chernenkiy.companyservice.dto.CompanyCreateUpdateDto;
import com.chernenkiy.companyservice.service.CompanyService;
import org.springframework.web.bind.annotation.*;
import service.company.CompanyDto;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{name}")
    public CompanyDto findByName(@PathVariable String name) {
        return companyService.findByName(name);
    }

    @GetMapping("/user/{id}")
    public CompanyDto findByEmployee(@PathVariable Long id) {
        return companyService.findByEmployeeId(id);
    }

    @PostMapping
    public CompanyDto createCompany(@RequestBody CompanyCreateUpdateDto dto) {
        return companyService.createCompany(dto);
    }
}