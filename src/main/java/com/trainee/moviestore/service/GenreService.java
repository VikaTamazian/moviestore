package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements AbstractService<Genre, Long> {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre create(Genre model) {
        return genreRepository.save(model);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    //TODO update as in UserMovieService
    @Override
    public Genre findById(Long value) {
        return genreRepository.findById(value).get();
    }

    //TODO update as in UserMovieService
    @Override
    public Genre update(Genre model) {
        return genreRepository.save(model);

    }

    @Override
    public void delete(Long value) {
        genreRepository.deleteById(value);
    }
}
