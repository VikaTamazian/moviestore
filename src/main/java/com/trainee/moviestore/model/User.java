package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long id;

    @Column(name = "")
    private String username;

    @Column(name = "")
    private String password;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @Column(name = "")
    @Enumerated(EnumType.STRING)
    @OneToMany(mappedBy = "user")
    private Role role;
}
