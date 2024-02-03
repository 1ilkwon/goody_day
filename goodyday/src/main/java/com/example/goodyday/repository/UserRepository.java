package com.example.goodyday.repository;


import com.example.goodyday.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDeviceId(String deviceId);



}


