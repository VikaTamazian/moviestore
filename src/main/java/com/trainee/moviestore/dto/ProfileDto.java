package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Profile;
import com.trainee.moviestore.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class ProfileDto {

    private long id;
    private User user;
    private String firstName;
    private String lastName;

    public Profile toProfile(){

        Profile profile = new Profile();
        profile.setId(id);
        profile.setUser(user);
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        return profile;
    }

    public ProfileDto fromProfile (Profile profile){

        ProfileDto profileDto =new ProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setUser(profile.getUser());
        profileDto.setFirstName(profile.getFirstName());
        profileDto.setLastName(profile.getLastName());
        return profileDto;
    }
}
