package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long genreId;
    @Column(name = "")
    private String genreName;
    @Column(name = "")
    private LocalDate created; //???
    @Column(name = "")
    private LocalDate updated; //???

}
