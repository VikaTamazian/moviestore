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

import static org.junit.jupiter.api.Assertions.*;
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
        Movie movie = createNew();
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        var movieCreated = movieService.create(movie);
        assertNotNull(movieCreated);
        assertEquals(movie, movieCreated);
        assertSame(movie, movieCreated);
        verify(movieRepository, times(1)).save(movie);
    }

    @Test
    void findByIdTest() {
        Movie movie = createNew();
        when(movieRepository.findById(any(Long.class))).thenReturn(Optional.of(movie));
        assertEquals(movie, movieService.findById(anyLong()));
        verify(movieRepository, times(1)).findById(anyLong());
    }


    @Test
    void getAllTest() {
        Movie movie1 = createNew();
        Movie movie2 = createNew();
        List<Movie> movies = Arrays.asList(movie1, movie2);
        when(movieRepository.findAll()).thenReturn(movies);
        var movieList = movieService.getAll();
        assertEquals(2, movieList.size());
        assertEquals(movies, movieList);
        assertSame(movies, movieList);
        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        Movie movie = createNew();
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

    private Movie createNew() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setAdult(true);
        movie.setBackdropPath("url");
        movie.setLanguage("en");
        movie.setTitle("title");
        movie.setOverview("overview");
        return movie;
    }

}