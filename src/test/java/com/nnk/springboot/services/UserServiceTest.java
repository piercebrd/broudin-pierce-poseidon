package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("admin");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Act
        List<User> result = userService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setUsername("admin");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        // Act
        User result = userService.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("admin", result.getUsername());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        // Arrange
        User user = new User();
        user.setUsername("admin");
        user.setPassword("password123");
        user.setFullname("Administrator");
        user.setRole("ADMIN");

        when(userRepository.save(user)).thenReturn(user);

        // Act
        User result = userService.save(user);

        // Assert
        assertNotNull(result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDelete() {
        // Arrange
        int id = 1;

        // Act
        userService.delete(id);

        // Assert
        verify(userRepository, times(1)).deleteById(id);
    }
}
