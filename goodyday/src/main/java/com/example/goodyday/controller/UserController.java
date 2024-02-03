package com.example.goodyday.controller;

import com.example.goodyday.model.User;
import com.example.goodyday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    // 유저 생성
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    // 모든 유저 조회
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{deviceId}")
    // 특정 유저 조회
    public User getUserById(@PathVariable String deviceId) {
        return userService.findByDeviceId(deviceId);
    }
}
