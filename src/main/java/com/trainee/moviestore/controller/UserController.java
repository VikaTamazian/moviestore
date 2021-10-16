package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.User;
import com.trainee.moviestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    private List<User> show() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    private User getUser(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping("/user/new")
    private User saveUser(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @PutMapping("/user/update")
    private User update(@RequestBody User user) {
        userService.update(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
    }


}
