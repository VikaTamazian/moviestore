package com.trainee.moviestore.service;

import com.trainee.moviestore.model.Profile;
import com.trainee.moviestore.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @InjectMocks
    private ProfileService profileService;
    @Mock
    private ProfileRepository profileRepository;

    @Test
    void createTest() {
        Profile profile = new Profile();
        when(profileRepository.save(any(Profile.class))).thenReturn(profile);
        assertNotNull(profileService.create(profile));
        verify(profileRepository, times(1)).save(profile);
    }

    @Test
    void findByIdTest() {
        Profile profile = new Profile();
        when(profileRepository.findById(any(Long.class))).thenReturn(Optional.of(profile));
        assertEquals(profile, profileService.findById(anyLong()));
        verify(profileRepository, times(1)).findById(anyLong());
    }


    @Test
    void getAllTest() {
        Profile profile1 = new Profile();
        Profile profile2 = new Profile();
        List<Profile> profiles = Arrays.asList(profile1, profile2);
        when(profileRepository.findAll()).thenReturn(profiles);
        assertEquals(2, profileService.getAll().size());
        verify(profileRepository, times(1)).findAll();
    }

    @Test
    void updateTest() {
        Profile profile = new Profile();
        when(profileRepository.save(any(Profile.class))).thenReturn(profile);
        assertEquals(profile, profileService.update(profile));
        verify(profileRepository, times(1)).save(profile);

    }

    @Test
    void deleteTest() {
        Long id = 2L;
        profileService.delete(id);
        verify(profileRepository, times(1)).deleteById(id);

    }

}