package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.model.Movie;
import lombok.Data;

import java.util.List;

/**
 * Implementation of a data transfer object for updating in the database
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieUpdateDto {

    private long id;
    private String adult;
    private String backdropPath;
    private List<Genre> genres;
    private String language;
    private String title;
    private String overview;

    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setId(getId());
        movie.setAdult(Boolean.parseBoolean(getAdult()));
        movie.setBackdropPath(getBackdropPath());
        movie.setGenres(getGenres());
        movie.setLanguage(getLanguage());
        movie.setTitle(getTitle());
        movie.setOverview(getOverview());
        return movie;
    }

    public MovieUpdateDto fromMovie(Movie movie) {
        MovieUpdateDto movieDto = new MovieUpdateDto();
        movieDto.setId(movie.getId());
        movieDto.setAdult(String.valueOf(movie.isAdult()));
        movieDto.setBackdropPath(movie.getBackdropPath());
        movieDto.setGenres(movie.getGenres());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setTitle(movie.getTitle());
        movieDto.setOverview(movie.getOverview());
        return movieDto;
    }

}
