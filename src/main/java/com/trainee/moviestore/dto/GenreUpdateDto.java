package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trainee.moviestore.model.Genre;
import lombok.Data;

/**
 * Implementation of a data transfer object for updating in the database
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreUpdateDto {

    private long id;
    private String name;

    public Genre toGenre() {
        Genre genre = new Genre();
        genre.setId(getId());
        genre.setName(getName());
        return genre;
    }

    public GenreUpdateDto fromGenre(Genre genre) {
        GenreUpdateDto genreDto = new GenreUpdateDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        return genreDto;
    }

}
