package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements AbstractService<Movie, Long> {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie model) {
        return movieRepository.save(model);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    //TODO update as in UserMovieService
    @Override
    public Movie findById(Long value) {
        return movieRepository.findById(value).get();
    }

    //TODO update as in UserMovieService
    @Override
    public Movie update(Movie model) {
        return movieRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        movieRepository.deleteById(value);
    }
}

