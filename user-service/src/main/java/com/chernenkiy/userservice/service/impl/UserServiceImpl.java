package com.chernenkiy.userservice.service.impl;

import com.chernenkiy.userservice.client.CompanyClient;
import com.chernenkiy.userservice.dto.UserCreateUpdateDto;
import com.chernenkiy.userservice.entity.UserEntity;
import com.chernenkiy.userservice.mapper.UserMapper;
import com.chernenkiy.userservice.repository.UserRepository;
import com.chernenkiy.userservice.service.UserService;
import org.springframework.stereotype.Service;
import service.company.CompanyDto;
import service.user.UserDto;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CompanyClient companyClient;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, CompanyClient companyClient) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.companyClient = companyClient;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDto createUser(UserCreateUpdateDto dto) {
        UserEntity userEntity = userRepository.save(userMapper.toEntity(dto));

        return userMapper.toDto(userEntity);
    }

    @Override
    public UserDto findByLastName(String lastName) {
        return userMapper.toDto(userRepository.findByLastName(lastName));
    }

    @Override
    public CompanyDto getCompanyByUserId(Long id) {
        return companyClient.getCompanyById(id);
    }
}