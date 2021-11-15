package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.model.Status;
import com.trainee.moviestore.model.User;
import com.trainee.moviestore.model.UserMovie;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Implementation of a data transfer object for updating in the database
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMovieUpdateDto {

    private long id;
    private String description;
    private int rating;
    private Status status;

    public UserMovie toUserMovie() {
        UserMovie userMovie = new UserMovie();
        userMovie.setId(getId());
        userMovie.setDescription(getDescription());
        userMovie.setRating(getRating());
        userMovie.setStatus(getStatus());
        return userMovie;
    }

    public UserMovieUpdateDto fromUserMovie(UserMovie userMovie) {
        UserMovieUpdateDto userMovieDto = new UserMovieUpdateDto();
        userMovieDto.setId(userMovie.getId());
        userMovieDto.setDescription(userMovie.getDescription());
        userMovieDto.setRating(userMovie.getRating());
        userMovieDto.setStatus(userMovie.getStatus());
        return userMovieDto;
    }
}
