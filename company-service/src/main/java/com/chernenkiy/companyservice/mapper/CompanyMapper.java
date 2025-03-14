package com.chernenkiy.companyservice.mapper;

import com.chernenkiy.companyservice.dto.CompanyCreateUpdateDto;
import com.chernenkiy.companyservice.entity.CompanyEntity;
import org.mapstruct.Mapper;
import service.company.CompanyDto;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toDto(CompanyEntity userEntity);

    CompanyEntity toEntity(CompanyCreateUpdateDto dto);

}