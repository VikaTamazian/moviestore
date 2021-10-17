package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.UserMovie;
import com.trainee.moviestore.service.UserMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-movies")
@RequiredArgsConstructor
public class UserMovieController {

    final UserMovieService userMovieService;

    @GetMapping("/")
    private List<UserMovie> show() {
        return userMovieService.getAll();
    }

    @GetMapping("/{id}")
    private UserMovie getUserMovie(@PathVariable("id") long id) {
        return userMovieService.findById(id);
    }

    @PostMapping("/")
    private UserMovie saveUserMovie(@RequestBody UserMovie userMovie) {
        userMovieService.create(userMovie);
        return userMovie;
    }

    @PutMapping("/")
    private UserMovie update(@RequestBody UserMovie userMovie) {
        userMovieService.update(userMovie);
        return userMovie;
    }

    @DeleteMapping("/{id}")
    private void deleteUserMovie(@PathVariable("id") long id) {
        userMovieService.delete(id);
    }


}
