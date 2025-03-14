package com.chernenkiy.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.company.CompanyDto;

@FeignClient(name = "company-service")
public interface CompanyClient {

    @GetMapping("/company/user/{id}")
    CompanyDto getCompanyById(@PathVariable Long id);

}