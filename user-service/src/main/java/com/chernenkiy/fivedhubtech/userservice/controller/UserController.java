package com.chernenkiy.fivedhubtech.userservice.controller;

import com.chernenkiy.fivedhubtech.userservice.dto.UserDto;
import com.chernenkiy.fivedhubtech.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto) {
        UserDto createdUser  = userService.createUser (userDto);
        return new ResponseEntity<>(createdUser , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        List<UserDto> users = userService.getAllUsers(page, size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser (@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUser  = userService.updateUser (id, userDto);
        return new ResponseEntity<>(updatedUser , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
        userService.deleteUser (id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}