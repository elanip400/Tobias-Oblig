package com.example.TobiasOblig.repository;


import com.example.TobiasOblig.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername(String username);
    User findByUsername(String username);
}