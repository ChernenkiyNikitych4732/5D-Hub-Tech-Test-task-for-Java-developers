package com.chernenkiy.fivedhubtech.userservice.repository;

import com.chernenkiy.fivedhubtech.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}