package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public Genre get(@PathVariable("id") long id) {
        return genreService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Genre save(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Genre update(@RequestBody Genre genre) {
        return genreService.update(genre);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") long id) {
        genreService.delete(id);
    }
}
