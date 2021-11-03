package com.trainee.moviestore.dtoTest;

import lombok.Data;

import java.util.Set;

@Data

public class UserDto {

    private long id;

    private String username;

    private String password;

    private String email;

    private Set<RoleDto> roles;

    private Set<UserMovieUpdateDto> userMovies;

}
