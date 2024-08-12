package com.example.blog.service;

import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test

    void saveUser(){
        User user = new User();
        user.setUserName("testuser");
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);
        
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUserName());
        verify(userRepository, times(1)).save(user);
}
    @Test
    void getUserById() {
        User user = new User();
        user.setId(1L);
        user.setUserName("testuser");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(1L);
        
        assertNotNull(foundUser);
        assertEquals(1L, foundUser.getId());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getAllUsers() {
        User user1 = new User();
        user1.setUserName("testuser1");

        User user2 = new User();
        user2.setUserName("testuser2");

        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> allUsers = userService.getAllUsers();

        assertEquals(2, allUsers.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void updateUser() {
        User existingUser = new User();
        existingUser.setId(1L);
        existingUser.setUserName("oldusername");

        User updatedUser = new User();
        updatedUser.setUserName("newusername");

        when(userRepository.existsById(1L)).thenReturn(true);
        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(updatedUser);

        User result = userService.updateUser(1L, updatedUser);

        assertNotNull(result);
        assertEquals("newusername", result.getUserName());
        verify(userRepository, times(1)).existsById(1L);
        verify(userRepository, times(1)).save(updatedUser);
    }

        @Test
        void deleteUser() {
        Long userId = 1L;
        
        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    
}
