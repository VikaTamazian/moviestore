package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Status;
import com.trainee.moviestore.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class StatusController {

    final StatusService statusService;

    @GetMapping
    private List<Status> getAll() {
        return statusService.getAll();
    }
}
