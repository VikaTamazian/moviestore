package com.trainee.moviestore.service;

import com.trainee.moviestore.model.User;
import com.trainee.moviestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements AbstractService<User, Long> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User model) {
        return userRepository.save(model);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long value) {
        return userRepository.findById(value).get();
    }

    @Override
    public User update(User model) {
        return userRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        userRepository.deleteById(value);
    }
}

