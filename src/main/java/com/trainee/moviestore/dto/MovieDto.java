package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trainee.moviestore.model.Genre;
import com.trainee.moviestore.model.Movie;
import com.trainee.moviestore.repository.GenreRepository;
import lombok.Data;

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
        movie.setGenres(getGenresList(genreIds));
        return movie;
    }

    public MovieDto fromUser(Movie movie) {

        MovieDto movieDto = new MovieDto();
        movieDto.setAdult(String.valueOf(movie.isAdult()));
        movieDto.setBackdropPath(movie.getBackdropPath());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setTitle(movie.getTitle());
        movieDto.setOverview(movie.getOverview());
        movieDto.setId(movie.getExternalId());
        movieDto.setGenreIds(getGenresId(movie.getGenres()));
        return movieDto;
    }

    public List<Genre> getGenresList(List<Long> genreIds) {

        List<Genre> genres = new ArrayList<>();
        genreIds.forEach(o -> {
            Genre genre = genreRepository.findByExternalId(o);
            genres.add(genre);
        });
        return genres;
    }

    public List<Long> getGenresId(List<Genre> genres) {

        return genres.stream().map(Genre::getId).collect(Collectors.toList());
    }

}
