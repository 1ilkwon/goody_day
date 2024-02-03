package com.example.goodyday.service;

import com.example.goodyday.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();

    User findByDeviceId(String deviceId);
}