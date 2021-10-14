package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.repository.GenreRepository;
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
class GenreServiceTest {

    @InjectMocks
    private GenreService genreService;
    @Mock
    private GenreRepository genreRepository;

    @Test
    void createTest() {
        Genre genre = new Genre();
        when(genreRepository.save(any(Genre.class))).thenReturn(genre);
        assertNotNull(genreService.create(genre));
        verify(genreRepository, times(1)).save(genre);
    }

    @Test
    void findByIdTest() {
        Genre genre = new Genre();
        long id = 2L;
        when(genreRepository.findById(any(Long.class))).thenReturn(Optional.of(genre));
        assertNotNull(genreService.findById(id));
        verify(genreRepository, times(1)).findById(id);
    }


    @Test
    void getAllTest() {
        Genre genre1 = new Genre();
        Genre genre2 = new Genre();
        List<Genre> genres = Arrays.asList(genre1, genre2);
        when(genreRepository.findAll()).thenReturn(genres);
        assertEquals(2, genreService.getAll().size());
        verify(genreRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        Genre genre = new Genre();
        when(genreRepository.save(any(Genre.class))).thenReturn(genre);
        genreService.update(genre);
        verify(genreRepository, times(1)).save(genre);

    }

    @Test
    void deleteTest() {
        Long id = 2L;
        genreService.delete(id);
        verify(genreRepository, times(1)).deleteById(id);

    }

}