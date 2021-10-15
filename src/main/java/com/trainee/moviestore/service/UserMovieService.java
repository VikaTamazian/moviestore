package com.trainee.moviestore.service;

import com.trainee.moviestore.model.UserMovie;
import com.trainee.moviestore.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMovieService implements AbstractService<UserMovie, Long> {

    private final UserMovieRepository userMovieRepository;

    @Autowired
    public UserMovieService(UserMovieRepository userMovieRepository) {
        this.userMovieRepository = userMovieRepository;
    }

    @Override
    public UserMovie create(UserMovie model) {
        return userMovieRepository.save(model);
    }

    @Override
    public List<UserMovie> getAll() {
        return userMovieRepository.findAll();
    }

    @Override
    public UserMovie findById(Long value) {
        return userMovieRepository.findById(value).get();
    }

    @Override
    public UserMovie update(UserMovie model) {
        return userMovieRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        userMovieRepository.deleteById(value);
    }
}

