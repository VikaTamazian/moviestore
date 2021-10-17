package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.repository.MovieRepository;
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
class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;
    @Mock
    private MovieRepository movieRepository;

    @Test
    void createTest() {
        Movie movie = new Movie();
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        assertNotNull(movieService.create(movie));
        verify(movieRepository, times(1)).save(movie);
    }

    @Test
    void findByIdTest() {
        Movie movie = new Movie();
        when(movieRepository.findById(any(Long.class))).thenReturn(Optional.of(movie));
        assertEquals(movie, movieService.findById(anyLong()));
        verify(movieRepository, times(1)).findById(anyLong());
    }


    @Test
    void getAllTest() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        List<Movie> movies = Arrays.asList(movie1, movie2);
        when(movieRepository.findAll()).thenReturn(movies);
        assertEquals(2, movieService.getAll().size());
        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        Movie movie = new Movie();
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        assertEquals(movie, movieService.update(movie));
        verify(movieRepository, times(1)).save(movie);

    }

    @Test
    void deleteTest() {
        Long id = 2L;
        movieService.delete(id);
        verify(movieRepository, times(1)).deleteById(id);

    }

}