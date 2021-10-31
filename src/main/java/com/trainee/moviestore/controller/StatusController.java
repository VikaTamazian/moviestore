package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class StatusController {


    @GetMapping
    private List<Status> getAll() {
        return Arrays.asList(Status.values());
    }
}
