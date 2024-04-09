package com.example.TobiasOblig.service;

import com.example.TobiasOblig.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List <User> getAllUsers();
    void saveUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, String username, String password, String email);
}