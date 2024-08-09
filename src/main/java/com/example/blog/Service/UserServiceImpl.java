
package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.streotype.servicez;


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
        if (userRepository.exsistsById(id)){
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
