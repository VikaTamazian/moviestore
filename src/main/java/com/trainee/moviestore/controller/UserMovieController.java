package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.UserMovie;
import com.trainee.moviestore.service.UserMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/favourites")
@RequiredArgsConstructor
public class UserMovieController {

    final UserMovieService userMovieService;

    @GetMapping
    private List<UserMovie> getAll(@RequestParam ("userId") Long userId) {
        return userMovieService.getAllByUser(userId);
    }

    @GetMapping("/{id}")
    private UserMovie get(@PathVariable("id") long id) {
        return userMovieService.findById(id);
    }

    @PostMapping
    private UserMovie saveUserMovie(@RequestBody UserMovie userMovie) {
        userMovieService.create(userMovie);
        return userMovie;
    }

    @PutMapping("/{id}")
    private UserMovie update(@PathVariable("id") Long id, @RequestBody UserMovie userMovie) {
        userMovie.setId(id);
        return userMovieService.update(userMovie);
    }

    @DeleteMapping("/{id}")
    private void deleteUserMovie(@PathVariable("id") long id) {
        userMovieService.delete(id);
    }


}
