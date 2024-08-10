
package com.example.blog.service;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @Override
    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public User updateUser(Long id, User user){
        if (userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }
    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
