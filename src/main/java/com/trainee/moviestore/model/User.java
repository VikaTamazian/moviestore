package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long userId;
    @Column(name = "")
    private String username;
    @Column(name = "")
    private String password;
    @Column(name = "")
    @Enumerated(EnumType.STRING)
    private Role role;
}
