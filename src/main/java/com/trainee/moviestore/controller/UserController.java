package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.User;
import com.trainee.moviestore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping
    private List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    private User get(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping
    private User save(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    private User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }
}
