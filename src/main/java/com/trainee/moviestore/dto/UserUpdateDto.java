package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class UserUpdateDto {
    private long id;
    private String username;
    private String password;
    private String email;

    public User toUser() {
        User user = new User();
        user.setId(getId());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setEmail(getEmail());
        return user;
    }

    public UserUpdateDto fromUser(User user) {
        UserUpdateDto userDto = new UserUpdateDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
