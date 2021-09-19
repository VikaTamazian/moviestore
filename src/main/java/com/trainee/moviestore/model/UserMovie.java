package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserMovie {
    private Movie movie;
    private User user;
    @Column(name = "")
    private double rating;
    @Column(name = "")
    private int favorite;
    @Column(name = "")
    private String review;

}
