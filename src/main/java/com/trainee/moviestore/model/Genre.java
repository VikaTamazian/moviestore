package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long id;

    @Column(name = "")
    private String genreName;

}
