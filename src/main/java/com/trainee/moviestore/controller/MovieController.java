package com.trainee.moviestore.controller;

import com.trainee.moviestore.dto.model.MovieDto;
import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.service.MovieService;
import com.trainee.moviestore.service.themoviedb.ThemoviedbServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    final MovieService movieService;

    final ThemoviedbServiceImpl themoviedbService;

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


    @PostMapping("/search")
    public ResponseEntity<?> getMovie (@RequestBody  String name) {
    List<MovieDto> movieDto = themoviedbService.getMovies();// name
     List<Movie> movies = movieDto.stream()
             .map(MovieDto::toMovie)
             .collect(Collectors.toList());
     return ResponseEntity.ok(movies);
    }



//
//    final MovieServiceDto movieServiceDto;
//
//    @GetMapping("/get")
//    private List<Movie> getAllMovie() {
//        return movieServiceDto.getAll();
//    }
}
