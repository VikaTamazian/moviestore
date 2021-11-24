package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Status;
import com.trainee.moviestore.model.UserMovie;
import com.trainee.moviestore.repository.UserMovieRepository;
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
class UserMovieServiceTest {

    @InjectMocks
    private UserMovieService userMovieService;
    @Mock
    private UserMovieRepository userMovieRepository;

    @Test
    void createTest() {
        UserMovie userMovie = new UserMovie();
        when(userMovieRepository.save(any(UserMovie.class))).thenReturn(userMovie);
        assertNotNull(userMovieService.create(userMovie));
        verify(userMovieRepository, times(1)).save(userMovie);
    }

    @Test
    void findByIdTest() {
        UserMovie userMovie = new UserMovie();
        when(userMovieRepository.findById(any(Long.class))).thenReturn(Optional.of(userMovie));
        assertEquals(userMovie, userMovieService.findById(anyLong()));
        verify(userMovieRepository, times(1)).findById(anyLong());
    }


    @Test
    void getAllTest() {
        UserMovie userMovie1 = new UserMovie();
        UserMovie userMovie2 = new UserMovie();
        List<UserMovie> statuses = Arrays.asList(userMovie1, userMovie2);
        when(userMovieRepository.findAll()).thenReturn(statuses);
        assertEquals(2, userMovieService.getAll().size());
        verify(userMovieRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        UserMovie userMovie = new UserMovie();
        when(userMovieRepository.save(any(UserMovie.class))).thenReturn(userMovie);
        assertEquals(userMovie, userMovieService.update(userMovie));
        verify(userMovieRepository, times(1)).save(userMovie);

    }

    @Test
    void deleteTest() {
        Long id = 2L;
        userMovieService.delete(id);
        verify(userMovieRepository, times(1)).deleteById(id);

    }

}