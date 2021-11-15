package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.model.Status;
import com.trainee.moviestore.model.UserMovie;
import lombok.Data;

/**
 * Implementation of a data transfer object for providing information
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMovieInfoDto {
    private String title;
    private int rating;
    private Status status;

    public UserMovie toUserMovie() {
        UserMovie userMovie = new UserMovie();
        Movie movie = new Movie();
        movie.setTitle(getTitle());
        userMovie.setMovie(movie);
        userMovie.setRating(getRating());
        userMovie.setStatus(getStatus());
        return userMovie;
    }

    public UserMovieInfoDto fromUserMovie(UserMovie userMovie) {
        UserMovieInfoDto userMovieDto = new UserMovieInfoDto();
        userMovieDto.setTitle(userMovie.getMovie().getTitle());
        userMovieDto.setRating(userMovie.getRating());
        userMovieDto.setStatus(userMovie.getStatus());
        return userMovieDto;
    }
}
