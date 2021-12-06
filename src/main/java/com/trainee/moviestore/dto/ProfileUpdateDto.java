package com.trainee.moviestore.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Profile;
import com.trainee.moviestore.model.User;
import lombok.Data;

/**
 * Implementation of a data transfer object for updating in the database
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileUpdateDto {

    private long id;
    private User user;
    private String firstName;
    private String lastName;

    public Profile toProfile() {
        Profile profile = new Profile();
        profile.setId(getId());
        profile.setUser(getUser());
        profile.setFirstName(getFirstName());
        profile.setLastName(getLastName());
        return profile;
    }

    public ProfileUpdateDto fromProfile(Profile profile) {
        ProfileUpdateDto profileDto = new ProfileUpdateDto();
        profileDto.setId(profile.getId());
        profileDto.setUser(profile.getUser());
        profileDto.setFirstName(profile.getFirstName());
        profileDto.setLastName(profile.getLastName());
        return profileDto;
    }

}
