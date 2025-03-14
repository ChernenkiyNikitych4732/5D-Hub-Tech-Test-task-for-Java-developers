package com.chernenkiy.userservice.controller;

import com.chernenkiy.userservice.dto.UserCreateUpdateDto;
import com.chernenkiy.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;
import service.company.CompanyDto;
import service.user.UserDto;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserCreateUpdateDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping("/{lastName}")
    public UserDto findByCompanyId(@PathVariable String lastName) {
        return userService.findByLastName(lastName);
    }

    @GetMapping("/get-company/{userId}")
    public CompanyDto getCompanyByUserId(@PathVariable Long userId) {
        return userService.getCompanyByUserId(userId);
    }
}