package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long movieId;
    @Column(name = "")
    private String poster;
    @Column(name = "")
    private double rating;
    @Column(name = "")
    private String genre;
    @Column(name = "")
    private String overview;
    @Column(name = "")
    private String creator;
    @Column(name = "")
    private String cast;


}
