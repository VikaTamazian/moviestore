package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Profile;
import com.trainee.moviestore.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService implements AbstractService<Profile, Long> {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(Profile model) {
        return profileRepository.save(model);
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    //TODO update as in UserMovieService
    @Override
    public Profile findById(Long value) {
        return profileRepository.findById(value).get();
    }

    //TODO update as in UserMovieService
    @Override
    public Profile update(Profile model) {
        return profileRepository.save(model);
    }

    @Override
    public void delete(Long value) {
        profileRepository.deleteById(value);
    }
}

