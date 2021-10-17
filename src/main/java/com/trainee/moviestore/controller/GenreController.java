package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    final GenreService genreService;

    @GetMapping("/")
    private List<Genre> show() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    private Genre getGenre(@PathVariable("id") long id) {
        return genreService.findById(id);
    }

    @PostMapping("/")
    private Genre saveGenre(@RequestBody Genre genre) {
        genreService.create(genre);
        return genre;
    }

    @PutMapping("/")
    private Genre update(@RequestBody Genre genre) {
        genreService.update(genre);
        return genre;
    }

    @DeleteMapping("/{id}")
    private void deleteGenre(@PathVariable("id") long id) {
        genreService.delete(id);
    }


}
