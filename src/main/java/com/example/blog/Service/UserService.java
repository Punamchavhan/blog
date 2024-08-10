package com.example.blog.service;


import com.example.blog.model.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}