package com.example.TobiasOblig.service;

import com.example.TobiasOblig.model.User;
import com.example.TobiasOblig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl (UserRepository userRepository) {this.userRepository = userRepository;}
    @Override
    public User getUserById(Long id){
        Optional <User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
    @Override
    public List<User> getAllUsers(){return userRepository.findAll();}
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public void updateUser(Long id, String username, String password, String email) {
        Optional <User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (username != null) { user.setUsername(username); }
            if(password != null) { user.setPassword(password); }
            if (email != null) { user.setEmail(email); }
            userRepository.save(user);
        }
    }
}