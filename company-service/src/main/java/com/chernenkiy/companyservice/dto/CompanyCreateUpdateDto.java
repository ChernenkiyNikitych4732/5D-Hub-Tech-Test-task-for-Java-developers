package com.chernenkiy.companyservice.dto;

import java.math.BigDecimal;

public class CompanyCreateUpdateDto {
    private String name;
    private BigDecimal budget;
    private Long[] employeesList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Long[] getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(Long[] employeesList) {
        this.employeesList = employeesList;
    }
}