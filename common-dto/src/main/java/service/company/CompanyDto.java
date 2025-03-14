package service.company;

import java.math.BigDecimal;
import java.util.List;

public class CompanyDto {
    private Long id;
    private String name;
    private BigDecimal budget;
    private List<Long> employeesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Long> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Long> employeesList) {
        this.employeesList = employeesList;
    }
}