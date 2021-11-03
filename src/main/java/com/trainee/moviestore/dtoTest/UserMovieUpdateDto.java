package com.trainee.moviestore.dtoTest;

import com.trainee.moviestore.model.Status;
import lombok.Data;

@Data
public class UserMovieUpdateDto {

    private long id;

    private String description;

    private int rating;

    private Status status;

}
