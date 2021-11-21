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
 * and further update it to the database.
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieUpdateTmdbDto {

    @JsonProperty("id")
    private long externalId;
    private String adult;
    @JsonProperty("poster_path")
    private String backdropPath;
    private List<GenreSaveTmdbDto> genres;
    @JsonProperty("original_language")
    private String language;
    private String title;
    private String overview;


    public Movie toMovie(MovieUpdateTmdbDto movieUpdateTmdbDto) {

        Movie movie = new Movie();
        Genre genre = new Genre();
        List<Genre> genreList = new ArrayList<>();

        for (GenreSaveTmdbDto genreDto : movieUpdateTmdbDto.getGenres()) {
            genre.setName(genreDto.getName());
            genre.setExternalId(genreDto.getExternalId());
            genreList.add(genre);
        }

        movie.setExternalId(getExternalId());
        movie.setAdult(Boolean.parseBoolean(getAdult()));
        movie.setBackdropPath(getBackdropPath());
        movie.setGenres(genreList);
        movie.setLanguage(getLanguage());
        movie.setTitle(getTitle());
        movie.setOverview(getOverview());

        return movie;
    }

}

