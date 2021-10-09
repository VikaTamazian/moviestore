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
        return null;
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public Genre findById(Long value) {
        return null;
    }

    @Override
    public void update(Genre model) {

    }

    @Override
    public void delete(Long value) {

    }
}
