package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    final MovieService movieService;

    @GetMapping("/")
    private List<Movie> show() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    private Movie getMovie(@PathVariable("id") long id) {
        return movieService.findById(id);
    }

    @PostMapping("/")
    private Movie saveMovie(@RequestBody Movie movie) {
        movieService.create(movie);
        return movie;
    }

    @PutMapping("/")
    private Movie update(@RequestBody Movie movie) {
        movieService.update(movie);
        return movie;
    }

    @DeleteMapping("/{id}")
    private void deleteMovie(@PathVariable("id") long id) {
        movieService.delete(id);
    }


}
