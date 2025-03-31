package com.chernenkiy.fivedhubtech.userservice.mapper;

import com.chernenkiy.fivedhubtech.userservice.dto.UserDto;
import com.chernenkiy.fivedhubtech.userservice.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {
    public UserDto toDto(UserEntity user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDate(user.getBirthDate().toString());
        return dto;
    }

    public UserEntity toEntity(UserDto dto) {
        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthDate(LocalDate.parse(dto.getBirthDate()));
        return user;
    }
}