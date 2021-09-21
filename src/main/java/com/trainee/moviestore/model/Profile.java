package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long id;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "")
    private String firstName;

    @Column(name = "")
    private String lastName;

    @Column(name = "")
    private String region;

    @Column(name = "")
    private String language;

    @Column(name = "")
    private Timestamp created;

    @Column(name = "")
    private Timestamp updated;
}
