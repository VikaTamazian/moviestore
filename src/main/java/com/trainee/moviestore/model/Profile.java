package com.trainee.moviestore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long profileId;
    @JoinColumn(name = "userId")
    private User user;
    @Column(name = "")
    private String avatar;
    @Column(name = "")
    private String firstName;
    @Column(name = "")
    private String lastName;
    @Column(name = "")
    private String region;
    @Column(name = "")
    private String language;
    @Column(name = "")
    private LocalDate created;
    @Column(name = "")
    private LocalDate updated;
}
