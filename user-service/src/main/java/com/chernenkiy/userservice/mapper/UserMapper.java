package com.chernenkiy.userservice.mapper;

import com.chernenkiy.userservice.dto.UserCreateUpdateDto;
import com.chernenkiy.userservice.entity.UserEntity;
import org.mapstruct.Mapper;
import service.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(UserEntity userEntity);

    UserEntity toEntity(UserCreateUpdateDto dto);
}