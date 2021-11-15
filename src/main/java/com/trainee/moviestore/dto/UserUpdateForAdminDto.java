package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Role;
import com.trainee.moviestore.model.User;
import lombok.Data;

import java.util.Set;

/**
 * Implementation of a data transfer object for updating in the database
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateForAdminDto {

    private long id;
    private String username;
    private String password;
    private String email;
    private Set<Role> roles;

    public User toUser() {
        User user = new User();
        user.setId(getId());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setEmail(getEmail());
        user.setRoles(getRoles());
        return user;
    }

    public UserUpdateForAdminDto fromUser(User user) {
        UserUpdateForAdminDto userDto = new UserUpdateForAdminDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}

