package com.example.TobiasOblig.controller;

import com.example.TobiasOblig.model.User;
import com.example.TobiasOblig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){this.userService = userService; }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){return userService.getUserById(id);}
    @PostMapping
    public void addUser(@RequestBody User user) {userService.saveUser(user);}
    @GetMapping()
    public List<User> getAllUsers(){return userService.getAllUsers();}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id); }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, String username, String password, String email) {
        userService.updateUser(id, username, password, email);
    }
}