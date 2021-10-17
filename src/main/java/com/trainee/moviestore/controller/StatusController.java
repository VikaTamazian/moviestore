package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Role;
import com.trainee.moviestore.model.Status;
import com.trainee.moviestore.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class StatusController {

    final StatusService statusService;

    @GetMapping("/")
    private List<Status> show() {
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    private Status getStatus(@PathVariable("id") long id) {
        return statusService.findById(id);
    }

    @PostMapping("/")
    private Status saveStatus(@RequestBody Status status) {
        statusService.create(status);
        return status;
    }

    @PutMapping("/")
    private Status update(@RequestBody Status status) {
        statusService.update(status);
        return status;
    }

    @DeleteMapping("/{id}")
    private void deleteStatus(@PathVariable("id") long id) {
        statusService.delete(id);
    }


}
