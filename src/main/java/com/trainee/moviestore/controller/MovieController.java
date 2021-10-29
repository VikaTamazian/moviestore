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

    @GetMapping
    private List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    private Movie get(@PathVariable("id") long id) {
        return movieService.findById(id);
    }

    @PostMapping
    private Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @PutMapping
    private Movie update(@RequestBody Movie movie) {
        return movieService.update(movie);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id) {
        movieService.delete(id);
    }
}
