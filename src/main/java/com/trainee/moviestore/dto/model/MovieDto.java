package com.trainee.moviestore.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.repository.GenreRepository;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {

    GenreRepository genreRepository;

    private long id;
    private String adult;
    @JsonProperty("poster_path")
    private String backdropPath;
    @JsonProperty("genre_ids")
    private List<Long> genreIds;
    @JsonProperty("original_language")
    private String language;
    private String title;
    private String overview;

    public Movie toMovie() {

        Movie movie = new Movie();
        movie.setAdult(Boolean.parseBoolean(getAdult()));
        movie.setBackdropPath(getBackdropPath());
        movie.setLanguage(getLanguage());
        movie.setTitle(getTitle());
        movie.setOverview(getOverview());
        movie.setExternalId(getId());
        movie.setGenres(getGenres(genreIds));
        return movie;
    }

    public List<Genre> getGenres(List<Long> genreIds) {

        List<Genre> genres = new ArrayList<>();
        genreIds.forEach(o -> {
            Genre genre = genreRepository.findByExternalId(o);
            genres.add(genre);
        });

//        return genreIds.forEach(id -> genreRepository.findByExternalId(id));

//        List<Genre> genres = genreIds.stream(ids -> {
//        genreRepository.findByExternalId(ids);
//        }).collect(Collectors.toList());
        return genres;
    }

}
