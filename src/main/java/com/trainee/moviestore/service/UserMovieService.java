package com.trainee.moviestore.service;

import com.trainee.moviestore.exception.MoviestoreServiceException;
import com.trainee.moviestore.model.UserMovie;
import com.trainee.moviestore.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<UserMovie> getAllByUser(Long userId) {
        return userMovieRepository.findAllByUserId(userId);
    }

    @Override
    public UserMovie findById(Long value) {
        return userMovieRepository.findById(value)
                .orElseThrow(() -> new MoviestoreServiceException(String.format("User movie with id: %s not exist", value)));
    }

    @Override
    @Transactional
    public UserMovie update(UserMovie model) {
        UserMovie existing = findById(model.getId());
        copyFields(existing, model);
        return userMovieRepository.save(existing);
    }

    @Override
    public void delete(Long value) {
        userMovieRepository.deleteById(value);
    }

    private void copyFields(UserMovie existing, UserMovie model) {
        existing.setDescription(model.getDescription());
        existing.setRating(model.getRating());
        existing.setStatus(model.getStatus());
    }
}

