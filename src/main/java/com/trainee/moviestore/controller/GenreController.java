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

    private final GenreService genreService;

    @GetMapping
    private List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    private Genre get(@PathVariable("id") long id) {
        return genreService.findById(id);
    }

    @PostMapping
    private Genre save(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @PutMapping
    private Genre update(@RequestBody Genre genre) {
        return genreService.update(genre);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id) {
        genreService.delete(id);
    }
}
