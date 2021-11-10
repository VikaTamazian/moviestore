package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.model.Movie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a data transfer object designed to convert json
 * and further save it to the database.
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSaveTmdbDto {

    @JsonProperty("id")
    private long externalId;
    private String adult;
    @JsonProperty("poster_path")
    private String backdropPath;
    @JsonProperty("genre_ids")
    private List<Long> genreIds;
    @JsonProperty("original_language")
    private String language;
    private String title;
    private String overview;

    public Movie toMovie(MovieSaveTmdbDto movieSaveTmdbDto) {

        Movie movie = new Movie();
        Genre genre = new Genre();
        List<Genre> genreList = new ArrayList<>();

        for (Long id : movieSaveTmdbDto.genreIds) {
            genre.setExternalId(id);
            genreList.add(genre);
        }

        movie.setAdult(Boolean.parseBoolean(getAdult()));
        movie.setBackdropPath(getBackdropPath());
        movie.setLanguage(getLanguage());
        movie.setTitle(getTitle());
        movie.setOverview(getOverview());
        movie.setExternalId(getExternalId());
        movie.setGenres(genreList);
        return movie;
    }

    public MovieSaveTmdbDto fromUser(Movie movie) {

        MovieSaveTmdbDto movieDto = new MovieSaveTmdbDto();
        List<Long> genreIdsList = new ArrayList<>();
        Long id = null;

        for (Genre genre : movie.getGenres()) {
            id = genre.getExternalId();
            genreIdsList.add(id);
        }

        movieDto.setAdult(String.valueOf(movie.isAdult()));
        movieDto.setBackdropPath(movie.getBackdropPath());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setTitle(movie.getTitle());
        movieDto.setOverview(movie.getOverview());
        movieDto.setExternalId(movie.getExternalId());
        movieDto.setGenreIds(genreIds);
        return movieDto;
    }
}
