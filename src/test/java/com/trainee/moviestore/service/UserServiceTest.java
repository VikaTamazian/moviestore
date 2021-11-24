package com.trainee.moviestore.service;

import com.trainee.moviestore.model.User;
import com.trainee.moviestore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void createTest() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        assertNotNull(userService.create(user));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void findByIdTest() {
        User user = new User();
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        assertEquals(user, userService.findById(anyLong()));
        verify(userRepository, times(1)).findById(anyLong());
    }


    @Test
    void getAllTest() {
        User user1 = new User();
        User user2 = new User();
        List<User> users = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(users);
        assertEquals(2, userService.getAll().size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        assertEquals(user, userService.update(user));
        verify(userRepository, times(1)).save(user);

    }

    @Test
    void deleteTest() {
        Long id = 2L;
        userService.delete(id);
        verify(userRepository, times(1)).deleteById(id);

    }

}