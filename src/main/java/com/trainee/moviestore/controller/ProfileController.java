package com.trainee.moviestore.controller;

import com.trainee.moviestore.model.Profile;
import com.trainee.moviestore.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

    final ProfileService profileService;

    @GetMapping
    private List<Profile> getAll() {
        return profileService.getAll();
    }

    @GetMapping("/{id}")
    private Profile get(@PathVariable("id") long id) {
        return profileService.findById(id);
    }

    @PostMapping
    private Profile save(@RequestBody Profile profile) {
        return profileService.create(profile);
    }

    @PutMapping
    private Profile update(@RequestBody Profile profile) {
        return profileService.update(profile);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id) {
        profileService.delete(id);
    }
}
