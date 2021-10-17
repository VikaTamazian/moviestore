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

    @GetMapping("/")
    private List<Profile> show() {
        return profileService.getAll();
    }

    @GetMapping("/{id}")
    private Profile getProfile(@PathVariable("id") long id) {
        return profileService.findById(id);
    }

    @PostMapping("/")
    private Profile saveProfile(@RequestBody Profile profile) {
        profileService.create(profile);
        return profile;
    }

    @PutMapping("/")
    private Profile update(@RequestBody Profile profile) {
        profileService.update(profile);
        return profile;
    }

    @DeleteMapping("/{id}")
    private void deleteProfile(@PathVariable("id") long id) {
        profileService.delete(id);
    }


}
