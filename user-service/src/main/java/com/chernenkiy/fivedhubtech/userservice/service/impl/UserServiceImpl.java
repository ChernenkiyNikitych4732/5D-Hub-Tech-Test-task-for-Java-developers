package com.chernenkiy.fivedhubtech.userservice.service.impl;

import com.chernenkiy.fivedhubtech.userservice.dto.UserDto;
import com.chernenkiy.fivedhubtech.userservice.entity.UserEntity;
import com.chernenkiy.fivedhubtech.userservice.exception.UserNotFoundException;
import com.chernenkiy.fivedhubtech.userservice.mapper.UserMapper;
import com.chernenkiy.fivedhubtech.userservice.repository.UserRepository;
import com.chernenkiy.fivedhubtech.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser (UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        UserEntity savedUser  = userRepository.save(userEntity);
        return userMapper.toDto(savedUser );
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toDto(userEntity);
    }

    @Override
    public List<UserDto> getAllUsers(int page, int size) {
        Page<UserEntity> userPage = userRepository.findAll(PageRequest.of(page, size));
        return userPage.getContent().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser (Long id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setBirthDate(LocalDate.parse(userDto.getBirthDate()));
        UserEntity updatedUser = userRepository.save(userEntity);
        return userMapper.toDto(updatedUser );
    }

    @Override
    public void deleteUser (Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(userEntity);
    }
}