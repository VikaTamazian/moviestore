package com.trainee.moviestore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trainee.moviestore.model.Genre;
import lombok.*;

/**
 * Implementation of a data transfer object designed to convert json
 * and further save it to the database.
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreSaveTmdbDto {

    @JsonProperty("id")
    private long externalId;
    private String name;

    public Genre toGenre() {
        Genre genre = new Genre();
        genre.setName(getName());
        genre.setExternalId(getExternalId());
        return genre;
    }

}
