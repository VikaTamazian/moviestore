package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long id;

    @Column(name = "")
    private String movieName;

    @Column(name = "")
    private String poster;

    @Column(name = "")
    private int rating;

    @OneToMany(mappedBy = "movie")
    private List<Genre> genre;

    @Column(name = "")
    private String overview;

    @Column(name = "")
    private String creator;

    @Column(name = "")
    private String cast;


}
