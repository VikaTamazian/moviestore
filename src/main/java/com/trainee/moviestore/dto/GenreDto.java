package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Genre;
import lombok.*;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDto {

    private long id;
    private String name;

    public Genre toGenre(GenreDto genreDto) {

        Genre genre = new Genre();
        genre.setName(genreDto.getName());
        genre.setExternalId(genreDto.getId());

        return genre;
    }

    public GenreDto fromGenre(Genre genre) {

        GenreDto genreDto = new GenreDto();
        genreDto.setName(genre.getName());
        genreDto.setId(genre.getExternalId());

        return genreDto;
    }

}
