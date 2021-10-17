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

    @GetMapping("/")
    private List<User> show() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    private User getUser(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    private User saveUser(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @PutMapping("/")
    private User update(@RequestBody User user) {
        userService.update(user);
        return user;
    }

    @DeleteMapping("/{id}")
    private void deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
    }


}
