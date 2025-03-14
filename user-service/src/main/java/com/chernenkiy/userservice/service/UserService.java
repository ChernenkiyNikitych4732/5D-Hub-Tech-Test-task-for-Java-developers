package com.chernenkiy.userservice.service;

import com.chernenkiy.userservice.dto.UserCreateUpdateDto;
import service.company.CompanyDto;
import service.user.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createUser(UserCreateUpdateDto dto);

    UserDto findByLastName(String lastName);

    CompanyDto getCompanyByUserId(Long id);

}