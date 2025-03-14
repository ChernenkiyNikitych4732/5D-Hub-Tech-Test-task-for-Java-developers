package com.chernenkiy.companyservice.repository;

import com.chernenkiy.companyservice.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    CompanyEntity findByName(String name);

}