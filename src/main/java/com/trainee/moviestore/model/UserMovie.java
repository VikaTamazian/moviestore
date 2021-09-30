package com.trainee.moviestore.model;

import lombok.Data;
import org.springframework.data.convert.Jsr310Converters;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "user_movie")
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "status_id")
    private long statusId;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private int rating;

    @Column(name = "created_timestamp")
    private LocalDateTime created;

    @Column(name = "updated_timestamp")
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Statuses status;
}
